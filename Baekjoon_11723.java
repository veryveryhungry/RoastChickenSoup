package baekjoon;

import java.util.*;

public class Baekjoon_11723 {
	public static Set<String> set = new HashSet<String>();
	public static void add(Set<String> set, String n) {
		set.add(n);
	}

	public static void remove(Set<String> set, String n) {
		Iterator<String> iter = set.iterator();
		String factor;
		while (iter.hasNext()) {
			factor = iter.next();
			if (factor == n)
				set.remove(n);
		}
	}

	public static void toggle(Set<String> set, String n) {
		Iterator<String> iter = set.iterator();
		String factor;
		boolean ok = false;
		while (iter.hasNext()) {
			factor = iter.next();
			if (factor == n) {
				set.remove(n);
				ok = true;
			}
		}
		if (ok == false)
			set.add(n);
	}

	public static int check(Set<String> set, String n) {
		Iterator<String> iter = set.iterator();
		String factor;
		while (iter.hasNext()) {
			factor = iter.next();
			if (factor == n) {
				return 1;
			}
		}
		return 0;
	}

	public static void all(Set<String> set) {
		String r;
		for (int k = 1; k < 21; k++) {
			r = "" + k;
			set.add(r);
		}
	}

	public static void empty(Set<String> set) {
		set.clear();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String s;
		String n;
		for (int i = 0; i < N; i++) {
			s = scan.next();
			if (s.equals("all"))
				all(set);
			else if (s.equals("empty"))
				empty(set);
			else {
				n=scan.next();
				switch (s) {
				case "add":
					add(set, n); break;
				case "check":
					check(set,n);break;
				case "remove":
					remove(set,n);break;
				case "toggle" : 
					toggle(set,n);break;
				}
			}

		}
		scan.close();
	}

}
