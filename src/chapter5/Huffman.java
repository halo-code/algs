package chapter5;

import chapter2_1.MinPQ;
import edu.princeton.cs.introcs.BinaryStdIn;
import edu.princeton.cs.introcs.BinaryStdOut;

public class Huffman {

	private static final int R = 256; // ASCII��ĸ��

	public static void compress() {
		String s = BinaryStdIn.readString();

		char[] input = s.toCharArray();

		int[] freq = new int[R];
		for (int i = 0; i < s.length(); i++) {
			freq[input[i]]++;// char �� intת��
		}

		// ����huffman
		Node root = buildTrie(freq);

		// ��������
		String[] st = new String[R];

		buildCode(st, root, "");

		writeTrie(root);

	}

	/**
	 * ��huffman��ǰ���������
	 * 
	 * @param x
	 *            ���ڵ�
	 */
	private static void writeTrie(Node x) {
		// TODO Auto-generated method stub
		if (x.isLeaf()) {
			BinaryStdOut.write(true);
			BinaryStdOut.write(x.ch);
			return;
		}
		BinaryStdOut.write(false);
		writeTrie(x.left);
		writeTrie(x.right);
	}

	// �ݹ�
	public static void buildCode(String[] st, Node x, String s) {

		if (x.isLeaf()) {
			st[x.ch] = s;
			return;
		}

		buildCode(st, x.left, s + '0');
		buildCode(st, x.right, s + '1');

	}

	public static Node buildTrie(int[] freq) {
		MinPQ<Node> pq = new MinPQ<Node>(freq.length);

		// ����С�������ȶ���
		for (char c = 0; c < R; c++) {
			if (freq[c] > 0) {
				pq.insert(new Node(c, freq[c], null, null));
			}
		}

		// �����ϲ���ֱ��ֻʣһ�����ڵ�
		while (pq.size() > 1) {
			Node x = pq.delMin();
			Node y = pq.delMin();

			Node parent = new Node('\0', x.freq + y.freq, x, y);
			pq.insert(parent);
		}
		return pq.delMin();

	}

	private static class Node implements Comparable<Node> {
		private int freq;
		private char ch;
		private final Node left, right;

		public Node(char ch, int freq, Node left, Node right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		public boolean isLeaf() {
			return (left == null && right == null);
		}

		@Override
		public int compareTo(Node other) {
			return this.freq - other.freq;
		}

	}
}
