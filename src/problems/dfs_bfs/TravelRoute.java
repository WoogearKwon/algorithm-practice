package problems.dfs_bfs;

import problems.Problem;

import java.util.*;

/**
 * <여행 경로/>
 * 원문 링크: https://programmers.co.kr/learn/courses/30/lessons/43164
 * 난이도: Level 3
 * <p>
 * <문제 설명/>
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때,
 * 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * <제한 사항/>
 * - 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
 * - 주어진 공항 수는 3개 이상 10,000개 이하입니다.
 * - tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
 * - 주어진 항공권은 모두 사용해야 합니다.
 * - 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
 * - 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 */
public class TravelRoute extends Problem {
    @Override
    public void run() {

//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        // return = ["ICN", "JFK", "HND", "IAD"]
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        // return = [ICN, ATL, ICN, SFO, ATL, SFO];
//        String[][] tickets = {{"ICN", "COO"}, {"COO", "ICN"}, {"COO", "ICN"}, {"ICN", "COO"}, {"ICN", "AAA"}};
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
