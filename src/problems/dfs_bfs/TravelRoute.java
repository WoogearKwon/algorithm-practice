package problems.dfs_bfs;

import problems.Problem;

import java.util.*;

public class TravelRoute extends Problem {
    @Override
    public void run() {

//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        // return = ["ICN", "JFK", "HND", "IAD"]
//         String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
         // return = [ICN, ATL, ICN, SFO, ATL, SFO];
        String[][] tickets = {{"ICN", "COO"}, {"COO", "ICN"}, {"COO", "ICN"}, {"ICN", "COO"}, {"ICN", "AAA"}};
        //return = [ICN, AAA, COO, COOO, ICN, ICN];

        printAnswer(solution(tickets));
    }

    boolean[] check;
    List<String> list = new ArrayList<>();
    String route = "";

    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            check = new boolean[tickets.length];
            String start = tickets[i][0], end = tickets[i][1];

            if (start.equals("ICN")) {
                route = start + ",";
                check[i] = true;
                dfs(end, tickets, 1);
            }
        }

        Collections.sort(list);

        return list.get(0).split(",");
    }

    private void dfs(String end, String[][] tickets, int count) {
        route += end + ",";

        if (count == tickets.length) {
            list.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String s = tickets[i][0], e = tickets[i][1];
            if (s.equals(end) && !check[i]) {
                check[i] = true;
                dfs(e, tickets, count + 1);
                check[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}
