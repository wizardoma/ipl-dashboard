package com.wizardom.ipldashboard.batch;


import com.wizardom.ipldashboard.batch.data.MatchInput;
import com.wizardom.ipldashboard.model.Match;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchInputProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(MatchInput matchInput) throws Exception {
        // set team 1 and team 2 depending on the innings order7
        String firstInningsTeam, secondInningsTeam;
        if ("bats".equals(matchInput.getToss_decision())){
            firstInningsTeam = matchInput.getToss_winner();
            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())?matchInput.getTeam2() : matchInput.getTeam1();
        }

        else {
            secondInningsTeam = matchInput.getToss_winner();
            firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())? matchInput.getTeam2() : matchInput.getTeam1();

        }
        return new Match()
                .setCity(matchInput.getCity())
                .setId(Long.parseLong(matchInput.getId()))
                .setDate(LocalDate.parse(matchInput.getDate()))
                .setMatchWinner(matchInput.getWinner())
                .setPlayerOfMatch(matchInput.getPlayer_of_match())
                .setResult(matchInput.getResult())
                .setResultMargin(matchInput.getResult_margin())
                .setCity(matchInput.getCity())
                .setTossWinner(matchInput.getToss_winner())
                .setTeam1(firstInningsTeam)
                .setTeam2(secondInningsTeam)
                .setTossDecision(matchInput.getToss_decision())
                ;

    }
}
