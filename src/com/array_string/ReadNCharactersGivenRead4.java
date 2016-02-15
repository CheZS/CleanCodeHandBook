package com.array_string;

public class ReadNCharactersGivenRead4 {

	public static void main(String[] args) {
		char[] s = new char[]{'a', 'b', 'c', 'd'};
		char[] d = new char[5];
		System.out.println("before:");
		System.out.println(s);
		System.out.println(d);
		System.arraycopy(s, 3, d, 0, 1);
		System.arraycopy(s, 0, d, 1, 4);
		System.out.println("after:");
		System.out.println(s);
		System.out.println(d);
	}
	/* the read function will only be called once for each test case */
	public int read(char[] buf, int n) {
		int readBytes = 0;
		char[] buffer = new char[4];
		boolean eof = false;
		while (!eof && readBytes < n) {
			int sz = read4(buffer);
			if (sz < 4) eof = true;
			int bytes = Math.min(sz, n - readBytes);
			System.arraycopy(buffer, 0, buf, readBytes, bytes);
			readBytes += bytes;
		}
		return readBytes;
	}
	
	private int read4(char[] buf) {
		/* read bytes from a file */
		/* buf is used to store data */
		/* return the size of read data */
		return buf.length;
	}
	
	/* the read function may be called multiple times */
	private char[] buffer = new char[4];
	private int offset = 0;
	private int bufsize = 0;
	
	public int read_2(char[] buf, int n) {
		int readBytes = 0;
		boolean eof = false;
		while (!eof && readBytes < n) {
			int sz = (bufsize > 0) ? bufsize : read4(buffer);
			if (bufsize == 0 && sz < 4) eof = true;
			int bytes = Math.min(sz, n - readBytes);
			System.arraycopy(buffer, offset, buf, readBytes, bytes);
			offset = (offset + bytes) % 4;
			bufsize = sz - bytes;
			readBytes += bytes;
		}
		return readBytes;
	}
}
