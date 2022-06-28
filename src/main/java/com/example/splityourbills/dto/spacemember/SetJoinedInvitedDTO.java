package com.example.splityourbills.dto.spacemember;

import java.util.List;

public class SetJoinedInvitedDTO {
    private List<Long> list;

    public SetJoinedInvitedDTO() {
    }


    public SetJoinedInvitedDTO(List<Long> list) {
        this.list = list;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }
}
