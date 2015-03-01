// WHAT (NOT) TO DO:
// -------------------
// REPLACE the "Exercise" lines with code (possibly empty code).
// LEAVE ALONE the "Exercise" lines for parts you are not solving.
//
// To get any marks for the whole exercise, your submission should
// compile using the "compile" script. Submissions that don't compile
// won't get any marks.

package maybe;

/**
 * Implementation of Nothing (using the "composite pattern").
 */

public class Nothing<A> implements Maybe<A> {

	public Nothing() {
		// throw new Exercise("Nothing:Nothing");
	}

	@Override
	public boolean isNothing() {
		// throw new Exercise("Nothing:isNothing");
		return true;
	}

	@Override
	public int size() {
		// throw new Exercise("Nothing:size");
		return 0;
	}

	@Override
	public String toString() {
		// throw new Exercise("Nothing:toString");
		return "Nothing";
	}

	@Override
	public boolean has(A a) {
		// throw new Exercise("Nothing:has");
		return false;
	}

	// Higher-order functions:

	@Override
	public Maybe<A> filter(Predicate<A> p) {
		// throw new Exercise("Nothing:filter");
		return this;
	}

	@Override
	public <B> Maybe<B> map(Function<A, B> f) {
		// throw new Exercise("Nothing:map");
		return new Nothing<B>();
	}

	@Override
	public <B> B fold(Function<A, B> f, B b) {
		// throw new Exercise("Nothing:fold");
		return b;
	}

	@Override
	public boolean all(Predicate<A> p) {
		// throw new Exercise("Nothing:all");
		return true;
	}

	@Override
	public boolean some(Predicate<A> p) {
		// throw new Exercise("Nothing:some");
		return false;
	}

	@Override
	public void forEach(Action<A> f) {
		// throw new Exercise("Nothing:forEach");
		// Nothing to do, but must have this method as Nothing implements the abstract class Maybe
	}

	// Unsafe operations:
	@Override
	public A fromMaybe() {
		// throw new Exercise("Nothing:fromMaybe");
		throw new RuntimeException("Nothing");
	}
}