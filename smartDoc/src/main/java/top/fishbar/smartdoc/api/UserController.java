package top.fishbar.smartdoc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fishbar.smartdoc.dto.UserDto;
import top.fishbar.smartdoc.model.CommonResult;
import top.fishbar.smartdoc.model.ResponseResult;

/**
 * 用户信息接口
 * @author niyihua
 *
 */
@RestController
@RequestMapping("/userinfo")
public class UserController {

    /**
     * 根据用户编码获取用户
     * @param code 用户编码
     * @return ResponseResult<UserDto>  top.fishbar.smartdoc.model.ResponseResult<UserDto>
     */
    @GetMapping("/getUserByCode/{code}")
    public ResponseResult<UserDto> getUserByCode(@PathVariable("code") String code){
        ResponseResult ok = ResponseResult.ok();
        ok.setData(new UserDto());
        return ok;
    }


}
