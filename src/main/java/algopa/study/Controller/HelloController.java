package algopa.study.Controller;

import algopa.study.domain.Member;
import algopa.study.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HelloController {
    private final MemberService memberService;

    @GetMapping("/")
    public String home(Model model){
        List<Member> members=memberService.findAllMembers();
        model.addAttribute("members", members);
        return "index";
    }

    @GetMapping(value = "/createMemberForm")
    public String createForm() {
        return "createMemberForm";
    }

    @PostMapping("/createMemberForm")
    public String create(MemberForm form){
        Member member=new Member();
        member.setName(form.getName());
        member.setTier(form.getTier());

        memberService.join(member);
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}",method = {RequestMethod.GET, RequestMethod.POST})
    public String delete(@PathVariable("id") Long id){
        System.out.println(id+"번 삭제");
        memberService.deleteMember(id);
        return "redirect:/";
    }
}
