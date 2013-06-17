package com.tomtresansky.projecteuler.util

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@Canonical
@ToString(includeNames=true, excludes="nodes")
class WeightedDirectedGraph {
  List sourceNodes = []
  List sinkNodes = []

  List nodes = []

  void print() {
    sourceNodes.each { printRec(it) }
  }

  void printRec(WeightedDirectedGraph.Node node) {
    println "Node: $node"
    node.outgoingEdges.each { edge ->
      printRec(edge.end)
    }
  }

  @Canonical
  @ToString(includeNames=true)
  @EqualsAndHashCode(includes="id")
  public static class Node {
    private static int nextId = 1

    int id = nextId++
    String label
    List outgoingEdges = []
    List incomingEdges = []
  }

  @Canonical
  public static class Edge {
    Node start
    Node end
    int weight

    String toString() {
      return "$start.id -> $end.id (weight: $weight)"
    }
  }

  private static WeightedDirectedGraph.Edge buildEdge(WeightedDirectedGraph.Node startNode, WeightedDirectedGraph.Node endNode, int weight) {
    def edge = new WeightedDirectedGraph.Edge(weight:weight, start:startNode, end:endNode)
    startNode.outgoingEdges << edge
    endNode.incomingEdges << edge
    return edge
  }

  /**
   * This should result in the nodes list being topologically sorted and the graph being an Acyclic Graph.
   */
  static WeightedDirectedGraph buildGraph(String data) {
    WeightedDirectedGraph graph = new WeightedDirectedGraph()
    def rows = data.split(/\n/).collect { r ->
      r.split(/\s/).collect { Integer.valueOf(it) }
    }

    // Setup external source nodes
    int sourceCount = 1
    graph.sourceNodes = rows[-1].collect { i -> new WeightedDirectedGraph.Node(label:'Source'+(sourceCount++), outgoingEdges:[]) }
    graph.nodes.addAll(graph.sourceNodes)

    List inputLayerNodes = [] // 1st layer nodes, source nodes will link to these
    List lastRowNodes = null
    rows.reverse().each { row ->
      List currRowNodes =  row.collect { weight -> new WeightedDirectedGraph.Node(label:weight, outgoingEdges:[]) }
      graph.nodes.addAll(currRowNodes)
      //println "this: $currRowNodes, last: $lastRowNodes"

      if (inputLayerNodes.isEmpty()) {
        inputLayerNodes.addAll(currRowNodes)
      }

      if (null != lastRowNodes) {
        int lim = currRowNodes.size()
        for (int i = 0; i < lim; i++) {
          // Add diagonal
          buildEdge(lastRowNodes[i + 1], currRowNodes[i], Integer.valueOf(currRowNodes[i].label))

          // Add straightlines
          buildEdge(lastRowNodes[i], currRowNodes[i], Integer.valueOf(currRowNodes[i].label))
        }
      }

      lastRowNodes = currRowNodes
    }

    graph.sinkNodes.addAll(lastRowNodes)

    // Link source to input layer
    int lim = graph.sourceNodes.size()
    for (int i = 0; i < lim; i++) {
      buildEdge(graph.sourceNodes[i], inputLayerNodes[i], Integer.valueOf(inputLayerNodes[i].label))
    }

    return graph
  }

  /**
   * Nodes list must be topologically sorted list of nodes for an Acyclic Graph.
   *
   * http://en.wikipedia.org/wiki/Longest_path_problem#Acyclic_graphs_and_critical_paths
   */
  def longestPath(WeightedDirectedGraph.Node startNode, WeightedDirectedGraph.Node endNode) {
    /*
     For each vertex v of the DAG, in the topological ordering, compute the length of
     the longest path ending at v by looking at its incoming neighbors and adding one
     to the maximum length recorded for those neighbors. If v has no incoming neighbors,
     set the length of the longest path ending at v to zero. In either case, record
     this number so that later steps of the algorithm can access it.
     */
    Map longestPaths = [:]
    nodes.each { v ->
      longestPaths[(v.id)] = longestPathInternal(longestPaths, v)
    }

    return longestPaths[(endNode.id)]
  }

  private int longestPathInternal(Map longestPaths, WeightedDirectedGraph.Node node) {
    // println "Known longest paths: $longestPaths"
    // println "Finding longestPath to $node"
    if (node.incomingEdges.isEmpty()) {
      return 0
    } else {
      WeightedDirectedGraph.Edge bestInputEdge = node.incomingEdges.max { incoming ->
        longestPaths[(incoming.start.id)] + incoming.weight
      }

      return longestPaths[(bestInputEdge.start.id)] + bestInputEdge.weight
    }
  }
}
