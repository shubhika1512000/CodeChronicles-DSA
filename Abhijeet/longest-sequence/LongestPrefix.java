public class LongestPrefix {

    public String longestCommonPrefix(String[] strs) {
        String comStr = strs[0];
        int limit = strs[0].length();

        for(int i = 1; i < strs.length; i++) {
            int newLimit = 0;
            limit = Math.min(limit, strs[i].length());
            for(int j=0; j < limit; j++) {
                if(strs[i].charAt(j) == comStr.charAt(j)){
                    newLimit++;
                }
                else break;
            }

            limit = newLimit;
            if(newLimit == 0) break;
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < limit; i++) {
            sb.append(comStr.charAt(i));
        }

        return sb.toString();
    }
}