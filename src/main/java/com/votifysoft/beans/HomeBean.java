package com.votifysoft.beans;

import com.votifysoft.css.HomeCss;
import com.votifysoft.repository.PersonRepository;

public class HomeBean {
    public void userDashboard(Boolean hasVoted) {

        String popupScript = hasVoted ? "alert('You have voted succesfully !');" : "";
    
    }
}
