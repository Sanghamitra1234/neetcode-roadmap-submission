class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
       List<String> partitions = new ArrayList<>(); 
       partitionUtil(s, partitions, 0);
       return result;
    }

    public void partitionUtil(String s, List<String> partitions, int index) {
        if (index >= s.length()) {
            if (isPalin(partitions)) {
                result.add(new ArrayList<>(partitions));
            }
          return;
        }
        if (partitions.size() > 0) {
            String lastString = partitions.remove(partitions.size() - 1);
            String newString = lastString + s.charAt(index) + "";
            partitions.add(newString);
            partitionUtil(s, partitions,index + 1);
            partitions.remove(partitions.size() - 1);
            partitions.add(lastString);
        }
        partitions.add(s.charAt(index) + "");
        partitionUtil(s, partitions ,index + 1);
        partitions.remove(partitions.size() - 1);
        return;
    }

    public boolean isPalin(List<String> partitions) {
        for (String partition: partitions) {
            String lastString = partition;
            int start = 0, end = lastString.length() - 1;
            while (start <= end) {
                if (lastString.charAt(start) != lastString.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
