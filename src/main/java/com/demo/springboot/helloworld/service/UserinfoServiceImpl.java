package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.mapper.ShopMapper;
import com.demo.springboot.helloworld.mapper.UserfinanceMapper;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import com.demo.springboot.helloworld.mapper.UserlevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserinfoServiceImpl implements UserinfoService{

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private UserlevelMapper userlevelMapper;

    @Autowired
    private UserfinanceMapper userfinanceMapper;

    @Autowired
    private ShopMapper shopMapper;
    @Override
    public UserinfoWithBLOBs updateInfo(String email, String newAdmin,String username, String sex, String birthdate, String phonenumber, String introduction,String file) {
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(email);
        UserinfoWithBLOBs result = userinfoMapper.selectByExampleWithBLOBs(userinfoExample).get(0);
        System.out.println("旧数据"+result.toString());
//        System.out.println(file);
        result.setUserAdmin(newAdmin);
        result.setUserId(result.getUserId());
        result.setUserName(username);
        result.setUsersex(Integer.parseInt(sex));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse(birthdate);
        result.setUserBirthdate(birthdate);
        result.setUserPhonenumber(phonenumber);
        result.setUserIntroduction(introduction);
        result.setUserImg(file.getBytes());
        System.out.println("新数据"+result.toString());
        int res = userinfoMapper.updateByPrimaryKeyWithBLOBs(result);

        return result;
    }

    @Override
    public List<UserinfoWithBLOBs> find(Long userId) {
//        userinfoMapper.selectByExample();
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserIdEqualTo(userId);
        List<UserinfoWithBLOBs> userinfo = userinfoMapper.selectByExampleWithBLOBs(userinfoExample);
        System.out.println(userinfo.toString());
        return userinfo;
    }

    @Override
    public List<UserinfoWithBLOBs> findWithAdmin(String userAdmin) {
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        List<UserinfoWithBLOBs> userinfo = userinfoMapper.selectByExampleWithBLOBs(userinfoExample);
        System.out.println(userinfo.toString());
        return userinfo;
    }

    @Override
    public boolean changepassword(String oldPassword,String newPassword,String userAdmin) {
       UserinfoExample userinfoExample = new UserinfoExample();
       userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        UserinfoWithBLOBs newuser = userinfoMapper.selectByExampleWithBLOBs(userinfoExample).get(0);
        System.out.println("正确密码"+newuser.getUserPassword());
        System.out.println("当前输入密码"+oldPassword);
        if(newuser.getUserPassword().equals(oldPassword)){
            newuser.setUserPassword(newPassword);
            int userinfo = userinfoMapper.updateByPrimaryKey(newuser);
            System.out.println("密码正确");
            return true;
        }
        else{
            System.out.println("密码错误");
            return false;
        }
    }

    @Override
    public boolean addUser(SignUp signUp) {

        //创建新用户信息
        UserinfoWithBLOBs userinfo = new UserinfoWithBLOBs();
        userinfo.setMessageId(null);
        userinfo.setLoginId(null);
        userinfo.setFinanceId(null);
        userinfo.setUseLevelId(null);
        userinfo.setShopId(null);
        userinfo.setSignUpId(signUp.getSignUpId());
        userinfo.setUserAdmin(signUp.getEmailAddress());
        userinfo.setUserPassword(signUp.getUserPassword());
        userinfo.setUserName(signUp.getUserName());
        userinfo.setUserTag(signUp.getIdentity());
        userinfo.setUsersex(null);
        userinfo.setUserIntroduction(null);
        userinfo.setUserPhonenumber(null);
        userinfo.setUserBirthdate(null);
        userinfo.setFinanceId(null);
        userinfo.setUserImg("123".getBytes());
        int result = userinfoMapper.insert(userinfo);
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(signUp.getEmailAddress());
        List<UserinfoWithBLOBs> userinfoList = userinfoMapper.selectByExampleWithBLOBs(userinfoExample);
        Userinfo newUserInfo = userinfoList.get(0);
        Long userId = userinfoList.get(0).getUserId();
        Boolean userTag = userinfoList.get(0).getUserTag();

        //创建新等级信息并将外键写入
        Userlevel userlevel = new Userlevel();
        userlevel.setUserId(userId);
        userlevel.setLevel(1);
        userlevel.setPoints(0);
        int levelResult = userlevelMapper.insert(userlevel);
        UserlevelExample userlevelExample = new UserlevelExample();
        userlevelExample.createCriteria().andUserIdEqualTo(userId);
        List<Userlevel> userlevels = userlevelMapper.selectByExample(userlevelExample);
        newUserInfo.setUseLevelId(userlevels.get(0).getLevelId());

        //创建新余额信息并将外键写入
        Userfinance userfinance = new Userfinance();
        userfinance.setUserId(userId);
        userfinance.setBalance((double) 0);
        int financeResult = userfinanceMapper.insert(userfinance);
        SignUp sign = signUpService.updateUserId(userinfoList.get(0));
        UserfinanceExample userfinanceExample = new UserfinanceExample();
        userfinanceExample.createCriteria().andUserIdEqualTo(userId);
        List<Userfinance> userfinances = userfinanceMapper.selectByExample(userfinanceExample);
        newUserInfo.setFinanceId(userfinances.get(0).getFinanceId());

        //判断用户是否是卖家
        if(userTag==true){
            //新建商店
            Shop shop = new Shop();
            shop.setUserId(userId);
            shop.setShopName("");
            shop.setShopMainBussiness("");
            shop.setShopStar((double) 1);
            shop.setShopDsp("");
            shop.setShopLoc("");
            ShopExample shopExample = new ShopExample();
            shopExample.createCriteria().andUserIdEqualTo(userId);
            List<Shop> shopList = shopMapper.selectByExample(shopExample);
            newUserInfo.setShopId(shopList.get(0).getShopId());
        }

        if(result==1 && levelResult==1 && financeResult==1){
            userinfoMapper.updateByPrimaryKey(newUserInfo);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Long selectid(String username){
        /*Long userid=userinfoMapper.selectid(username);
        System.out.println("service:"+userid);
        System.out.println(username);*/
        return userinfoMapper.selectid(username);
    }
}
