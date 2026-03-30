class Solution {

    class TrieNode
    {
        TrieNode[] children;
        int count;

        public TrieNode()
        {
            this.children = new TrieNode[26];
            this.count = 0;
        }
    }

    class Trie
    {

        private TrieNode root;

        public Trie()
        {
            this.root = new TrieNode();
        }

        public void insert(String word)
        {
            TrieNode curr = root;

            for(int i = 0;i<word.length();i++)
            {
                char ch = word.charAt(i);
                int index = ch - 'a';

                if(curr.children[index] == null)
                    curr.children[index] = new TrieNode();
                
                curr.children[index].count++;
                
                curr = curr.children[index];
            }
        }

        public String commonPrefix(String word,int numWords)
        {
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;

            for(int i = 0;i<word.length();i++)
            {
                char ch = word.charAt(i);
                int index = ch - 'a';

                if(curr.children[index] == null || curr.children[index].count != numWords)
                    break;
                
                sb.append(ch);

                curr = curr.children[index];
            }

            return sb.toString();

        }
    }

    public String longestCommonPrefix(String[] strs) {

        Trie t = new Trie();
        int n = strs.length;

        for(String w : strs)
        {
            t.insert(w);
        }

        String ans = ""; 
        int len = 0;

        for(String w : strs)
        {
            String commonPref = t.commonPrefix(w,n);
            if(commonPref.length() > len)
            {
                len = commonPref.length();
                ans = commonPref;
            }
        }

        return ans;

        
    }
}