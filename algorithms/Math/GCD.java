public class GCD {
    // 欧几里得算法 https://baike.baidu.com/item/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95#:~:text=%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95%E5%8F%88%E7%A7%B0%E8%BE%97%E8%BD%AC%E7%9B%B8%E9%99%A4%E6%B3%95,b%E7%9A%84%E6%9C%80%E5%A4%A7%E5%85%AC%E7%BA%A6%E6%95%B0%E3%80%82&text=%E8%AE%A1%E7%AE%97%E5%85%AC%E5%BC%8Fgcd(a%2Cb,%E5%A4%9A%E7%A7%8D%E7%BC%96%E7%A8%8B%E8%AF%AD%E8%A8%80%E5%AE%9E%E7%8E%B0%E3%80%82
    // 定理：两个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数。最大公约数（Greatest Common Divisor）缩写为GCD。
    // gcd(a,b) = gcd(b,a mod b) (不妨设a>b 且r=a mod b ,r不为0)
    // O(loga)  https://www.geeksforgeeks.org/c-program-find-gcd-hcf-two-numbers/
    // Recursive function to return gcd of a and b
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else 
            return gcd(b, a % b); 
    }
}