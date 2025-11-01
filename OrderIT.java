import java.util.*;
public class OrderIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0;
        try {
            String countLine = sc.nextLine();
            if (countLine != null && !countLine.trim().isEmpty()) {
                n = Integer.parseInt(countLine);
            }
        } catch (Exception e) {
            System.out.println(0);
            sc.close();
            return;
        }

        if (n == 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        sc.nextLine(); 
        String[] currentOrder = new String[n];
        for (int i = 0; i < n; i++) {
            currentOrder[i] = sc.nextLine();
        }

        sc.nextLine(); 
        Map<String, Integer> correctPositionMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            correctPositionMap.put(sc.nextLine(), i);
        }

        int[] targetIndices = new int[n];
        for (int i = 0; i < n; i++) {
            targetIndices[i] = correctPositionMap.get(currentOrder[i]);
        }

        List<Integer> blockStartValues = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            blockStartValues.add(targetIndices[i]);
            while (i + 1 < n && targetIndices[i + 1] == targetIndices[i] + 1) {
                i++;
            }
        }

        int totalBlocks = blockStartValues.size();
        if (totalBlocks == 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        int[] lisLengthEndingAt = new int[totalBlocks];
        Arrays.fill(lisLengthEndingAt, 1);
        int maxSubsequenceLength = 1;

        for (int i = 0; i < totalBlocks; i++) {
            for (int j = 0; j < i; j++) {
                if (blockStartValues.get(i) > blockStartValues.get(j)) {
                    lisLengthEndingAt[i] = Math.max(lisLengthEndingAt[i], lisLengthEndingAt[j] + 1);
                }
            }
            maxSubsequenceLength = Math.max(maxSubsequenceLength, lisLengthEndingAt[i]);
        }

        System.out.println(totalBlocks - maxSubsequenceLength);

        sc.close();
    }
}
