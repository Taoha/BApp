package com.lanou.taochangjun.gift.projectbapp.internet;

/**
 * Created by dllo on 17/2/21.
 * 制作者:张德鹏 2月21日
 * 全部网络的接口
 *
 */

public class Url {


    public static  int index =0;

    // 首页的附页接口全部***************************
    public static final String ONE = "http://m.live.netease.com/bolo/api/zone/categoryVideoList.htm?len=5&zoneId=";
    public static final String TWO = "http://m.live.netease.com/bolo/api/zone/zoneNewVideoList.htm?pageNum=";


    // 游戏杂谈
    public static final String GAMETALK =ONE+ "14847213448701 ";
    public static final String GAMETALKUNDER =TWO+ "&zoneId=14847213448701&pageSize=16";
    public static final int GAMETALKCode = index++;
    public static final int GAMETALKUNDERCode = index++;

    // 搞笑
    public static final String FUNNY = ONE+"14679608401831";
    public static final String FUNNYUNDER =TWO+ "&zoneId=14679608401831&pageSize=16";
    public static final int FUNNYCode = index++;
    public static final int FUNNYUNDERCode = index++;


    // 动画
    public static final String ANIMATIO = ONE+"14679608401821";
    public static final String ANIMATIONUNDER = TWO+"&zoneId=14679608401821&pageSize=16";
    public static final int ANIMATIOCode = index++;
    public static final int ANIMATIONUNDERCode = index++;


    // 萌宠
    public static final String ANIMAL =ONE+ "14679608401781";
    public static final String ANIMALUNDER = TWO+"&zoneId=14679608401781&pageSize=16";
    public static final int ANIMALCode = index++;
    public static final int ANIMALUNDERCode = index++;


    // 美食
    public static final String FOOD = ONE+"14679608401801";
    public static final String FOODUNDER = TWO+"&zoneId=14679608401801&pageSize=16";
    public static final int FOODCode = index++;
    public static final int FOODUNDERCode = index++;


    // 二次元
    public static final String EMELENT =ONE+ "14679608401851";
    public static final String EMELENTUNDER = "&zoneId=14679608401851&pageSize=16";
    public static final int EMELENTCode = index++;
    public static final int EMELENTUNDERCode = index++;


    // 八卦头条
    public static final String HEADLINES = ONE+"14679608401791";
    public static final String HEADLINESUNDER = TWO+"&zoneId=14679608401791&pageSize=16";
    public static final int HEADLINESCode = index++;
    public static final int HEADLINESUNDERCode = index++;


    // 网剧
    public static final String TV = ONE+"14679608401841";
    public static final String TVUNDER =TWO+ "&zoneId=14679608401841&pageSize=16";
    public static final int TVCode = index++;
    public static final int TVUNDERCode = index++;

    // LOL
    public static final String LOL = "14836951235121";
    public static final String LOLUNDER = TWO+"&zoneId=14836951235121&pageSize=16";
    public static final int LOLCode = index++;
    public static final int LOLUNDERCode = index++;


    // 炉石传说
    public static final String STONE = ONE+"14836951235151";
    public static final String STONEUNDER = TWO+"&zoneId=14836951235151&pageSize=16";
    public static final int STONECode = index++;
    public static final int STONEUNDERCode = index++;


    // 守望先锋
    public static final String VANGUARD = ONE+"14836951235161";
    public static final String VANGUARDUNDER =TWO+ "&zoneId=14836951235161&pageSize=16";
    public static final int VANGUARDCode = index++;
    public static final int VANGUARDUNDERCode = index++;



    // 推荐页全部接口 ************************

    // 动画轮播图
    public static final String CAROUSEL = "http://m.live.netease.com/bolo/api/index/bannerVideoNew.htm ";
    public static final int CAROUSELCode = index++;

    // 菠萝菌力荐
    public static final String PINEAPPLE = "http://m.live.netease.com/bolo/api/index/videoRecommend.htm?pageNum=1";
    public static final int PINEAPPLECode = index++;

    // 人气周榜
    public static final String PEOPLE = "http://m.live.netease.com/bolo/api/index/dailyPopList.htm?pageNum=1&pageSize=9";
    public static final int PEOPLECode = index++;

    // 菠萝专辑
    public static final String ALBUM = "http://m.live.netease.com/bolo/api/index/hotVideoAlbum.htm";
    public static final int ALBUMCode = index++;

    // 附页全部

    public static final String OTHER = "http://m.live.netease.com/bolo/api/index/showZoneList.htm?len=5";
    public static final int OTHERCode = index++;

    // 小鲜肉棒

    public static final String SMALL = "http://m.live.netease.com/bolo/api/index/freshSetList.htm?pageNum=1&pageSize=9";
    public static final int SMALLCode = index++;

    // 热门UP主

    public static final String UP = "http://m.live.netease.com/bolo/api/index/hotUp.htm?userId=5702015542626208498";
    public static final int UPCode = index++;


    // 为您推荐

    public static final String RECOMMEND = "http://m.live.netease.com/bolo/api/index/personalizedRecommend.htm?pageNum=1&userId=5702015542626208498&pageSize=20";
    public static final int RECOMMENDCode = index++;



    // 最火的页面 **************************************************

    // 卫星图标
    public static final String SATELLITE = "http://m.live.netease.com/bolo/api/rank/sceneList.htm";

    // 放饭
    public static final String FIREONE = "http://m.live.netease.com/bolo/api/rank/hotVideo.htm?type=LUNCKBREAK&userId=5702015542626208498";
    // 无聊
    public static final String FIRETWO = "http://m.live.netease.com/bolo/api/rank/hotVideo.htm?type=BORING&userId=5702015542626208498";
    // 蹲坑
    public static final String FIRETHREE = "http://m.live.netease.com/bolo/api/rank/hotVideo.htm?type=TOILET&userId=5702015542626208498";
    // 躺在床上
    public static final String FIREFOUR = "http://m.live.netease.com/bolo/api/rank/hotVideo.htm?type=BEFORE_BED&userId=5702015542626208498";

    // 加载中的图片


    // *****************发现 *************
    public static final String SEARCH = "http://m.live.netease.com/bolo/api/search/hotSearchWords.htm";
    public static final int SEARCHCODE = index++;
    public static final String ALL = "http://m.live.netease.com/bolo/api/zone/zoneList.htm";
    public static final int ALLCODE = index++;

    // 关注*******************************
    public static final String ATTENTION = "http://m.live.netease.com/bolo/api/index/recommendFollow.htm?pageNum=1&userId=5702015542626208498&pageSize=4";
    public static final String ATTENTIONUNDER = "http://m.live.netease.com/bolo/api/index/personalizedRecommend.htm?pageNum=2&userId=5702015542626208498&pageSize=20";











}
