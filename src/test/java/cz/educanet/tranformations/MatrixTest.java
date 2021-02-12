package cz.educanet.tranformations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixTest {

	private IMatrix a;
	private IMatrix b;
	private IMatrix c;
	private IMatrix d;
	private IMatrix e;
	private IMatrix f;
	private IMatrix g;
	private IMatrix h;
	private IMatrix i;
	private IMatrix res1;
	private IMatrix res2;
	private IMatrix empty;

	@Before
	public void setUp() throws Exception {
		double[][] rawA = {
				{1, 1, 1},
				{1, 1, 1},
		};
		a = MatrixFactory.create(rawA);

		double[][] rawB = {
				{1, 1, 1},
				{1, 1, 1},
				{0, 0, 0},
		};
		b = MatrixFactory.create(rawB);
		double[][] rawC = {
				{1, 0, 0},
				{0, 1, 0},
				{0, 0, 1},
		};
		c = MatrixFactory.create(rawC);

		double[][] rawEmpty = {};
		empty = MatrixFactory.create(rawEmpty);

		double[][] rawD = {
				{1, 1}
		};

		//*nasobeni

		d = MatrixFactory.create(rawD);

		double[][] rawE = {
				{2, -1, 3},
				{3, 0, -2},
		};
		e = MatrixFactory.create(rawE);

		double[][] rawF = {
				{1, 1},
				{2, -2},
				{3, 1},
		};
		f = MatrixFactory.create(rawF);

		double[][] rawResult = {
				{5.0, -1.0, 1.0},
				{-2.0, -2.0, 10.0},
				{9.0, -3.0, 7.0}
		};
		res1 = MatrixFactory.create(rawResult);

        double[][] rawResult2 = {
                {9,7},
                {-3,1},
        };
        res2 = MatrixFactory.create(rawResult2);

		//*nasobeni skalarem + scitani


		double[][] rawG = {
				{2, -1, 3},
				{3, 0, -2}
		};
		g = MatrixFactory.create(rawG);

		double[][] rawH = {
				{4, -2, 6},
				{6, 0, -4}
		};
		h = MatrixFactory.create(rawH);
	}

	@Test
	public void getRows() {
		assertEquals(2, a.getRows());
		assertEquals(3, b.getRows());
		assertEquals(3, c.getRows());
		assertEquals(0, empty.getRows());
	}

	@Test
	public void getColumns() {
		assertEquals(3, a.getColumns());
		assertEquals(3, b.getColumns());
		assertEquals(3, c.getColumns());
		assertEquals(0, empty.getColumns());
	}

	@Test
	public void times() {
		assertEquals(res2,e.times(f));
		assertEquals(res1,f.times(e));
	}

	@Test
	public void timesScalar() {
        assertEquals(h,g.times(2));
    }

	@Test
	public void add() {
        assertEquals(h,g.times(g));
	}

	@Test
	public void get() {
		assertEquals(1, (long) a.get(1, 1));
	}

	@Test
	public void transpose() {
	}

	@Test
	public void determinant() {
        //*tohle jindy, nestíhám moc, ale bude to
	}
}
