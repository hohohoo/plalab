package com.skplanet.plalab.googleDrive.hello.service;

import com.skplanet.plalab.googleDrive.hello.model.Member;
import com.skplanet.plalab.googleDrive.hello.model.exception.BadRequestException;
import com.skplanet.plalab.googleDrive.hello.repository.MemberRepository;
import com.skplanet.plalab.googleDrive.logger.ApplicationLoggerNameFactory;
import org.slf4j.Logger;
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

    private Logger applicationLogger = ApplicationLoggerNameFactory.getApplicationLogger();

    @Override
    public String add(Member member) {

        try {
            Member affectedRows = memberRepository.save(member);
            applicationLogger.info("ADD ".concat("").concat(" USER"));
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
        applicationLogger.info("GET ALL MEMBER LIST");
        return memberRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        memberRepository.delete(id);
        applicationLogger.info("DELETE ".concat("id").concat(" USER"));
    }

    @Override
    public void update(Integer id,Member member) {
        Member updatedMember = memberRepository.findOne(id);
        updatedMember.setMember(member);
        memberRepository.save(updatedMember);
        applicationLogger.info("UPDATE ".concat("id").concat(" USER TO ").concat("id"));
    }
}
