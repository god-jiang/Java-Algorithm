package leetcode;

import java.util.*;

/**
 * leetcode332题，重新安排行程
 *
 * @author god-jiang
 */
public class FindItinerary {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> list = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(list);
        return list;
    }

    public void dfs(String cur) {
        while (map.containsKey(cur) && map.get(cur).size() > 0) {
            String temp = map.get(cur).poll();
            dfs(temp);
        }
        list.add(cur);
    }
}
