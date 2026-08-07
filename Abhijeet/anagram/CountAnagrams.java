import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {

    public int countAnagrams(String s) {
        long long_mod = 1000_000_007L;
        String[] words = s.split(" ");
        long finalNumerator = 1;
        long finalDinominator = 1;

        for(String word: words) {
            Map<Character, Long> map = new HashMap<>();
            long numerator = 1;
            long dinominator = 1;

            for(int i = 0; i < word.length(); i++) {
                long count = map.getOrDefault(word.charAt(i), 0L);
                
                long temp = (numerator * (i + 1)) ;
                count = count + 1;
                
                numerator = temp % long_mod;
                dinominator = (dinominator * count) % long_mod;

                map.put(word.charAt(i), count);
            }

            finalNumerator = (finalNumerator * (numerator % long_mod)) % long_mod;
            finalDinominator = (finalDinominator * (dinominator % long_mod)) % long_mod;
        }

        long inverse = modPow(finalDinominator, long_mod - 2, long_mod);

        int wordCount = (int) ((finalNumerator * inverse) % long_mod); 

        return wordCount;
    }

    // Fermets Fermat's Little Theorem for dinominator modulus
    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}

// a = 1
// ab = a.2
// abc = ab.3
// abcc = abc.4/2
// abccd = abcc.5
// abccdc = abccd.6/3 => 6!/ 3!
// abccdcd = abccdc.7/2 => 7!/3!2!

/**
 * The logic is correct but the code has mistake in : 
 *      prevCount = (temp / count) % 1000_000_007L;
 *  
 * Assuming that temp is always completely divisible by count is the mistake. 
 * 
 * Fermet's Little Theoram
 * In modular arithmetic, you cannot directly divide like in normal arithmetic.
 * For example, in your expression:
 *  ((prevCount * (i+1)) / (count+1)) % 1000_000_007L;
 * 
 * The / (count+1) part is problematic because division under modulo requires 
 *  special handling.
 * 
 * ✅ The Correct Approach
 * To handle division in modulo, you use the modular multiplicative inverse.
 * 
 * If you want to compute 
 *  (𝑎/𝑏) mod𝑀
 * you instead compute:
 *  (𝑎⋅𝑏^−1) mod𝑀 
 * where 𝑏^−1 is the modular inverse of 𝑏 under modulo 𝑀.
 * 
 * For prime modulus (like 10^9+7), the inverse can be found using 
 * Fermat’s Little Theorem:
 *   𝑏^−1 ≡ 𝑏^(𝑀−2) mod𝑀
 * 
 */

/*  JAVA CODE FOR MODULAR INVERSE OF PRIME WITH FERMET LITTLE THEORAM

        static final long MOD = 1_000_000_007L;

        // Fast exponentiation to compute modular inverse
        static long modPow(long base, long exp, long mod) {
            long result = 1;
            base %= mod;
            while (exp > 0) {
                if ((exp & 1) == 1) result = (result * base) % mod;
                base = (base * base) % mod;
                exp >>= 1;
            }
            return result;
        }

        static long modInverse(long b, long mod) {
            return modPow(b, mod - 2, mod); // Fermat's theorem
        }

        // Usage
        long numerator = prevCount * (i + 1) % MOD;
        long denominator = count + 1;
        long result = numerator * modInverse(denominator, MOD) % MOD;

*/

/**
 * Optimzation
 * If I have used the Fixed size array instead of Hashmap, 
 * it would have took benefit of CPU L caches.   
 */