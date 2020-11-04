package com.xiaotao.system.dto;

import lombok.Data;

@Data
public class UserSearchDto {

        private String username;

        private String nickname;

        private String email;

        private Integer sex;

        private Long departmentId;
}