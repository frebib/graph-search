package search;

import ilist.IList;
import maybe.Maybe;
import search.graph.Graph;
import search.graph.NicksGraph;
import search.graph.Node;
import search.graphics.GraphViewer;

/**
 * A class to test the Search methods on a graph
 *
 * @author Jack Hair
 */

public class Test {
	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		final Graph<Coordinate> nicksGraph = NicksGraph.getGraph();
		final Node<Coordinate> start = nicksGraph.nodeWith(new Coordinate(0, 0));
		final Node<Coordinate> goal = new Node<Coordinate>(new Coordinate(9, 6));
		final Node<Coordinate> inaccessable = new Node<Coordinate>(new Coordinate(4, 0));

		// Assert that the findNodeFrom methods work correctly
		assert (!BreadthFirst.findPathFrom(start, goal).isNothing());
		assert (!DepthFirst.findPathFrom(start, goal).isNothing());
		assert (BreadthFirst.findPathFrom(start, inaccessable).isNothing());
		assert (DepthFirst.findPathFrom(start, inaccessable).isNothing());

		Maybe<IList<Node<Coordinate>>> bf = BreadthFirst.findPathFrom(start, goal);
		Maybe<IList<Node<Coordinate>>> df = DepthFirst.findPathFrom(start, goal);

		Maybe<IList<Node<Coordinate>>> asy = AStar.findPathFrom(start, goal, SearchFunction.euclidean, SearchFunction.manhattan);
		Maybe<IList<Node<Coordinate>>> asn = AStar.findPathFrom(start, inaccessable, SearchFunction.euclidean, SearchFunction.manhattan);
		System.out.println(bf + "\n" + df);
		System.out.println(asy + "\n" + asn);

		GraphViewer.traversePath(bf.fromMaybe(), 350, "Breadth First Search");
		GraphViewer.traversePath(df.fromMaybe(), 350, "Depth First Search");
		GraphViewer.traversePath(asy.fromMaybe(), 350, "A* Search");
	}

	@SuppressWarnings("unused")
	private static Node<Coordinate> getTestGraph() {
		Node<Coordinate> n1 = new Node<Coordinate>(new Coordinate(0, 0));	// 0,0
		Node<Coordinate> n2 = new Node<Coordinate>(new Coordinate(1, 1));	// / \
		Node<Coordinate> n3 = new Node<Coordinate>(new Coordinate(1, 2));	// 1,1 1,2
		Node<Coordinate> n4 = new Node<Coordinate>(new Coordinate(2, 3));	// / \ / \
		Node<Coordinate> n5 = new Node<Coordinate>(new Coordinate(2, 4));	// 2,3 2,4 2,6 2,7
		Node<Coordinate> n6 = new Node<Coordinate>(new Coordinate(2, 6));
		Node<Coordinate> n7 = new Node<Coordinate>(new Coordinate(2, 7));

		n3.addSuccessor(n6);
		n3.addSuccessor(n7);

		n2.addSuccessor(n4);
		n2.addSuccessor(n5);

		n1.addSuccessor(n2);
		n1.addSuccessor(n3);

		return n1;
	}
}