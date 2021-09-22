package org.codingnojam.springbootjpastudy.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.codingnojam.springbootjpastudy.domain.Address;
import org.codingnojam.springbootjpastudy.domain.Member;
import org.codingnojam.springbootjpastudy.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PostMapping("api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        Address address = new Address(request.getCity(), request.getStreet(), request.getZipcode());
        member.setAddress(address);
        member.setName(request.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PutMapping("api/v2/members/{id}")
    public UpdateMemberResponse updateMember(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberRequest request) {
        memberService.update(id, request.getName());
        Member member = memberService.findMember(id);
        return new UpdateMemberResponse(member.getId(), member.getName());
    }

    @GetMapping("api/v1/members")
    public List<Member> getMembersV1() {
        return memberService.fineMembers();
    }

    @GetMapping("api/v2/members")
    public GetMemberResponse getMembersV2() {
        List<Member> members = memberService.fineMembers();
        List<GetMemberDto> getMembers = members.stream()
                .map(m -> new GetMemberDto(m.getName(),
                        m.getAddress().getCity(),
                        m.getAddress().getStreet(),
                        m.getAddress().getStreet()))
                .collect(Collectors.toList());
        return new GetMemberResponse(getMembers, getMembers.size());
    }

    @Data
    @AllArgsConstructor
    static class GetMemberResponse<T> {
        private T data;
        private int count;
    }

    @Data
    @AllArgsConstructor
    static class GetMemberDto {
        private String name;
        private String city;
        private String street;
        private String zipcode;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        private Long id;
        private String name;
    }

    @Data
    static class UpdateMemberRequest {
        @NotEmpty
        private String name;
    }

    @Data
    static class CreateMemberRequest {
        private String name;
        private String city;
        private String street;
        private String zipcode;
    }

    @Data
    class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }
}
