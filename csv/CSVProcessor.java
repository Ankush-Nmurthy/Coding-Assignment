package com.example.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CSVProcessor {

	public static void main(String[] args) {
		String inputFilePath = "C:\\Users\\Ankush N\\OneDrive\\Desktop\\temp folder\\Book1.csv";
		String outputFilePath = "output.csv";

		try {
			// process the input data and stores in itself.
			List<List<String>> inputData = readCSV(inputFilePath);

			// process the output data and evaluates all the formula and append the actual
			// value.
			List<List<String>> outputData = processCSV(inputData);

			// writes the value to a given loaction.
			writeCSV(outputData, outputFilePath);
			System.out.println("CSV processing completed successfully.");
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	/**
	 * This method read the file and convert the input values to list of list such
	 * that the values are represented in the 2D format such that each row and
	 * column represents the value.
	 * 
	 * @param filePath
	 * @return List<List<String>>
	 * @throws IOException
	 */
	public static List<List<String>> readCSV(String filePath) throws IOException {
		List<List<String>> data = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			while (line != null) {
				String[] values = line.split(","); // this line split the string to string array.
				List<String> row = new ArrayList<>();
				for (String value : values) {
					row.add(value);
				}
				line = br.readLine();
				System.out.println(row);
				data.add(row);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	/**
	 * This method takes the parameter which was previously processed and converted
	 * into List<List<String>> after this it will loop over every row and if any row
	 * contains formula then that formula will be evaluated to a actuall value
	 * 
	 * @param List<List<String>> inputdata;
	 * @return List<List<String>>
	 */
	public static List<List<String>> processCSV(List<List<String>> inputData) {
		List<List<String>> outputData = new ArrayList<>();
		for (List<String> row : inputData) {
			List<String> outputRow = new ArrayList<>();
			for (String cell : row) {
				outputRow.add(evaluateCell(cell, inputData));
			}
			outputData.add(outputRow);
		}
		return outputData;
	}

	/**
	 * If the formula starts with the "=" sign then only it will calculate the value
	 * corresponding to it else it wont be calculated.
	 * 
	 * @param cell
	 * @param data
	 * @return String
	 */
	public static String evaluateCell(String cell, List<List<String>> data) {
		if (cell.startsWith("=")) {
			return evaluateFormula(cell.substring(1), data);
		} else {
			return cell;
		}
	}

	public static String evaluateFormula(String formula, List<List<String>> data) {
		String[] tokens = formula.split("\\+");
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (token.matches("[A-Z]\\d+")) {
				String[] coordinates = token.split("(?<=\\D)(?=\\d)");
				int row = Integer.parseInt(coordinates[1]) - 1;
				int col = coordinates[0].charAt(0) - 'A';
				stack.push(Integer.parseInt(data.get(row).get(col)));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return String.valueOf(result);
	}

	/**
	 * Take the data which is successfully processed and then this value will be
	 * written into the new destination file
	 * 
	 * @param data
	 * @param filePath
	 * @throws IOException
	 */
	public static void writeCSV(List<List<String>> data, String filePath) throws IOException {
		try (FileWriter writer = new FileWriter(filePath)) {
			for (List<String> row : data) {
				writer.append(String.join(",", row));
				writer.append("\n");
			}
		}
	}
}
