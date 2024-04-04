public class Robin_Karp {
    public final static int d = 256;

    static void search(String pattern, String txt, int p) {
        int m = pattern.length();
        int n = txt.length();
        int i, j;
        int pnum = 0;
        int tnum = 0;
        int h = 1;

        for (i = 0; i < m - 1; i++) 
        {
        	h = (h * d) % p;
        }
            

        for (i = 0; i < m; i++)
        {
            pnum = (d * pnum + pattern.charAt(i)) % p;
            tnum = (d * tnum + txt.charAt(i)) % p;
        }

        for (i = 0; i <= n - m; i++)
        {
            if (pnum == tnum)
            {
                for (j = 0; j < m; j++)
                {
                    if (txt.charAt(i + j) != pattern.charAt(j)) 
                    {
                    	break;
                    }
                        
                }
                if (j == m)
                {
                	System.out.println("Pattern found at index " + i);
                }
                    
            }

            if (i < n - m) 
            {
                tnum = (d * (tnum - txt.charAt(i) * h) + txt.charAt(i + m)) % p;
                if (tnum < 0)
                {
                	tnum += p;
                }
                    
            }
        }
    }

    public static void main(String[] args)
    {
        String txt = "abcfhabcaftheababc";
        String pattern = "abc";
        int p = 13; 
        search(pattern, txt, p);
    }
}


