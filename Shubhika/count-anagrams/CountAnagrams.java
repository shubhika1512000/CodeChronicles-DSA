// LeetCode 2514 - Count Anagrams
// Approach: Combinatorics (Factorial + Modular Inverse)
// Time Complexity: O(n) | Space Complexity: O(n)

// IDEA:
// For each word, the number of distinct arrangements (permutations) is:
//
//        word.length!
//   ─────────────────────────────
//   freq(a)! × freq(b)! × ... (for each character)
//
// Example: "too" → length=3, freq(t)=1, freq(o)=2
//   → 3! / (1! × 2!) = 6 / 2 = 3 distinct arrangements: too, oto, oot
//
// Multiply the results for all words together → final answer mod 10^9+7
//
// Since we need division in modular arithmetic, we use
// Modular Inverse via Fermat's Little Theorem:
//   a^(-1) mod p = a^(p-2) mod p   (when p is prime)

public class CountAnagrams {

    static final long MOD = 1_000_000_007;

    // Compute base^exp % MOD using fast exponentiation
    private long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) result = result * base % mod;
            base = base * base % mod;
            exp /= 2;
        }
        return result;
    }

    // Modular inverse of a number: a^(MOD-2) % MOD
    private long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    public int countAnagrams(String s) {
        // Precompute factorials up to length of s
        int n = s.length();
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        long answer = 1;

        // Process each word separately
        String[] words = s.split(" ");
        for (String word : words) {
            // Count frequency of each character in this word
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // Multiply answer by word.length! (numerator)
            answer = answer * fact[word.length()] % MOD;

            // Divide by freq(c)! for each character (denominator)
            for (int f : freq) {
                if (f > 1) {
                    answer = answer * modInverse(fact[f], MOD) % MOD;
                }
            }
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        CountAnagrams solution = new CountAnagrams();

        // Test case 1
        // "too" → 3!/(1!×2!) = 3  |  "hot" → 3!/(1!×1!×1!) = 6  →  3×6 = 18
        System.out.println("Input:  \"too hot\"");
        System.out.println("Output: " + solution.countAnagrams("too hot"));
        // Output: 18

        System.out.println();

        // Test case 2
        // "aa" → 2!/(2!) = 1
        System.out.println("Input:  \"aa\"");
        System.out.println("Output: " + solution.countAnagrams("aa"));
        // Output: 1

        System.out.println();

        // Test case 3
        // "ab" → 2!/(1!×1!) = 2  |  "cd" → 2!/(1!×1!) = 2  →  2×2 = 4
        System.out.println("Input:  \"ab cd\"");
        System.out.println("Output: " + solution.countAnagrams("ab cd"));
        // Output: 4
    }
}
