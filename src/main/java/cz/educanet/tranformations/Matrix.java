package cz.educanet.tranformations;

import kotlin.NotImplementedError;

import java.util.Arrays;

public class Matrix implements IMatrix {

	private final double[][] rawArray;

	public Matrix(double[][] rawArray) {
		this.rawArray = rawArray;
	}

	@Override
	public int getRows() {
		return rawArray.length;
	}

	@Override
	public int getColumns() {
		if (getRows() > 0)
			return rawArray[0].length;

		return 0;
	}

	@Override
	public IMatrix times(IMatrix matrix) {
		if (this.getColumns() == matrix.getRows()) {
			double[][] newMatrix = new double[this.getRows()][matrix.getColumns()];
			double tileValue;
			for (int firstMatrixRow = 0; firstMatrixRow < this.getRows(); firstMatrixRow++) {
				for (int secondMatrixColumn = 0; secondMatrixColumn < matrix.getColumns(); secondMatrixColumn++) {
					tileValue = 0.0d;
					for (int firstMatrixColumn = 0; firstMatrixColumn < this.getColumns(); firstMatrixColumn++) {
						tileValue += this.get(firstMatrixRow, firstMatrixColumn) * matrix.get(firstMatrixColumn, secondMatrixColumn);
					}
					newMatrix[firstMatrixRow][secondMatrixColumn] = tileValue;
				}
			}
			return MatrixFactory.create(newMatrix);
		}
		return null;
	}

	@Override
	public IMatrix times(Number scalar) {
		double[][] newMatrix = new double[this.getRows()][this.getColumns()];
		for (int row = 0; row < this.getRows(); row++) {
			for (int column = 0; column < this.getColumns(); column++) {
				newMatrix[row][column] = this.get(row, column) * scalar.doubleValue();
			}
		}
		return MatrixFactory.create(newMatrix);
	}

	@Override
	public IMatrix add(IMatrix matrix) {
		double[][] newMatrix = new double[this.getRows()][this.getColumns()];
		if (this.getRows() != matrix.getRows() || this.getColumns() != matrix.getColumns()) {
			return null;
		} else {
			for (int row = 0; row < matrix.getRows(); row++) {
				for (int column = 0; column < matrix.getColumns(); column++) {
					newMatrix[row][column] = this.get(row, column) + matrix.get(row, column);
				}
			}
			return MatrixFactory.create(newMatrix);
		}
	}

	@Override
	public double get(int n, int m) {
		return this.rawArray[n][m];
	}

	//region Optional
	@Override
	public IMatrix transpose() {
		return null;
	}

	@Override
	public double determinant() {
		return 0;
	}

	//endregion
	//region Generated
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Matrix matrix = (Matrix) o;

		for (int i = 0; i < rawArray.length; i++) {
			if (!Arrays.equals(rawArray[i], matrix.rawArray[i]))
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(rawArray);
	}
	//endregion
}