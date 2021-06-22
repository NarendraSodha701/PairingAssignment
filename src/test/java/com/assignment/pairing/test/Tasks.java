package com.assignment.pairing.test;

import java.util.Arrays;

public class Tasks {

private int num;
private int dep[][];

public Tasks(int num) {
    this.num = num;
    dep = new int[num][num];

}

public boolean dependsOn(int task1, int task2) {
    if (task1 > num - 1 || task2 > num - 1 || task1 < 0 || task2 < 0 || task1 == task2) {
        return false;
    } else
        dep[task1][task2] = 1;
    return true;

}

public int[] order() {
    int[] tasks = new int[num];
    int k = 0;
    int flag = 0;
    
    int[] visited = new int[num];

    
    for (int i = 0; i < num; i++) {
        for (int j = 0; j < num; j++) {
            if (dep[i][j] == 1) {
                
                flag++;
                System.out.println(i + " " + j);
                print();
                dep[i][j]--;
                
                visited[j]++;
                System.out.println(Arrays.toString(visited));
                
            }

        }
        if (flag == 0) {

            tasks[k] = i;
            k++;

        }


        flag = 0;

    }

    print();
    return tasks;
}



	public  void main(String[] args) {
		print();
		
	}


public void print() {

    for (int row = 0; row < dep.length; row++)// Cycles through rows
    {
        for (int col = 0; col < dep[row].length; col++)// Cycles through columns
        {
            System.out.printf("%5d", dep[row][col]); // change the %5d to however much space you want
        }
        System.out.println(); // Makes a new row
    }

    System.out.println();
}
}