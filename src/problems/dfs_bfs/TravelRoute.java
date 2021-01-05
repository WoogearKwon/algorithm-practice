package problems.dfs_bfs;

import problems.Problem;

import java.util.*;

public class TravelRoute extends Problem {
    @Override
    public void run() {

//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        // return = ["ICN", "JFK", "HND", "IAD"]
         String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
         // return = [ICN, ATL, ICN, SFO, ATL, SFO];

        printAnswer(solution(tickets));
    }

    boolean[] check;
    List<String> list = new ArrayList<>();
    String route = "";

    /**
     * <내 풀이/>
     * 1. tickets를 목적지의 알파벳 순으로 정렬 => 중복 검사를 할 필요가 없음
     * 2. ICN 출발점 찾기
     * 3. 경로를 지난 티켓은 check에 true 처리 => 지나간 루트는 검사하지 않음
     * 4.
     * */
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

    private int getNextTicket(String departure, String[][] tickets) {
        int position = -1;
        for (int i = 0; i < tickets.length; i++) {
            if (departure.equals(tickets[i][0]) && !check[i]) {
                position = i;
                check[i] = true;
                break;
            }
        }
        return position;
    }
}
