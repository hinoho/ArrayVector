//package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector{
    private double[] array;
    @Override
    public void set(double... elements) {
        array = new double[elements.length];
        System.arraycopy(elements, 0, array, 0, elements.length);
    }

    public ArrayVectorImpl() {
    }

    public ArrayVectorImpl(double[] array) {
        this.array = array;
    }

    @Override
    public double[] get() {
        return array;
    }

    @Override
    public ArrayVector clone() {
        ArrayVector arrayVector = new ArrayVectorImpl();
        arrayVector.set(array.clone());
        return arrayVector;
    }

    @Override
    public int getSize() {
        return array.length;
    }

    @Override
    public void set(int index, double value) {
        if(index>0) {
            if (index > array.length -1) {
                double[] tmp_array = new double[index+1];
                System.arraycopy(array, 0, tmp_array, 0, array.length);
                tmp_array[index] = value;
                array = tmp_array;
            } else {
                array[index] = value;
            }
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return array[index];
    }

    @Override
    public double getMax() {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max<array[i]){
                max = array[i];
            }
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min>array[i]){
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(array);
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < array.length; i++) {
            array[i]*=factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        for (int i = 0; i < array.length; i++) {
            if(anotherVector.getSize()<i){
                break;
            }
            array[i]+=anotherVector.get(i);
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double scalar = 0;
        int lenght = anotherVector.getSize()>array.length ? array.length : anotherVector.getSize();
        for (int i = 0; i < lenght; i++) {
            scalar+=(array[i]*anotherVector.get(i));
        }
        return scalar;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(scalarMult(this));
    }
}
