package com.skplanet.plalab.googleDrive.hello.web;

import com.skplanet.plalab.googleDrive.hello.model.Member;
import com.skplanet.plalab.googleDrive.hello.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author kyeongmin kim
 */

@RestController
@RequiredArgsConstructor
public class MemberController {

    @NotNull
    private final MemberService memberService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Member> list() {
        return memberService.getAllMember();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@RequestBody Member member) {
        return memberService.add(member);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam(value = "id") Integer id) {
        memberService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestParam(value = "id") Integer id, @RequestBody Member member) {
        memberService.update(id,member);
    }

}


