package com.skplanet.plalab.googleDrive.hello.service;

import com.skplanet.plalab.googleDrive.hello.model.Member;
import com.skplanet.plalab.googleDrive.hello.model.exception.BadRequestException;
import com.skplanet.plalab.googleDrive.hello.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author kyeongmin kim
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public String add(Member member) {

        try {
            Member affectedRows = memberRepository.save(member);
            if (affectedRows == null) {
                throw new BadRequestException("");
            }
        }catch (Exception e){
            throw new BadRequestException("member info need");
        }

        return member.toString();
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        memberRepository.delete(id);
    }

    @Override
    public void update(Integer id,Member member) {
        Member updatedMember = memberRepository.findOne(id);
        updatedMember.setMember(member);
        memberRepository.save(updatedMember);
    }
}
