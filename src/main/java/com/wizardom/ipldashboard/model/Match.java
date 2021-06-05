package com.wizardom.ipldashboard.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Accessors(chain = true)
@Data
public class Match {
    private long id;
    private String city;
    private LocalDate date;
    private String playerOfMatch;
    private String venue;
    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String matchWinner;
    private String result;
    private String resultMargin;
    private String umpire1;
    private String umpire2;
}
