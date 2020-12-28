package problems.dfs_bfs;

import problems.Problem;

import java.util.Arrays;
import java.util.Comparator;

public class TravelRoute extends Problem {
    @Override
    public void run() {

//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        // return = ["ICN", "JFK", "HND", "IAD"]
         String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
         // return = [ICN, ATL, ICN, SFO, ATL, SFO];

        printAnswer(solution(tickets));
    }

    String[] answer;
    boolean[] check;

    /**
     * <내 풀이/>
     * 1. tickets를 목적지의 알파벳 순으로 정렬 => 중복 검사를 할 필요가 없음
     * 2. ICN 출발점 찾기
     * 3. 경로를 지난 티켓은 check에 true 처리 => 지나간 루트는 검사하지 않음
     * 4.
     * */
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        check = new boolean[tickets.length];

        Arrays.sort(tickets, Comparator.comparing(o -> o[1])); // 목적지의 알파벳순으로 정렬
        answer[0] = "ICN";
        int prev = getNextTicket("ICN", tickets);;

        for (int i = 1; i < answer.length; i++) {
            answer[i] = tickets[prev][1];
            prev = getNextTicket(tickets[prev][1], tickets);
        }

        return answer;
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
