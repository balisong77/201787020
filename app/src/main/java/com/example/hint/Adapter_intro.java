package com.example.hint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_intro extends RecyclerView.Adapter<Adapter_intro.LinearViewholder> {
    private Context mcontext;
    public Adapter_intro(Context context){
        this.mcontext=context;
    }
    @NonNull
    @Override
    public Adapter_intro.LinearViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LinearViewholder(LayoutInflater.from(mcontext).inflate(R.layout.intro_item,viewGroup,false));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter_intro.LinearViewholder viewHolder, final int i) {
        if (i==0){
            viewHolder.title.setText("微软技术组");
            viewHolder.content.setText("    未来的路，用代码铸造\n" +
                    "\n" +
                    "    微软技术组介绍\n" +
                    "    微软技术组，简称为MS Tech，原为c#组，后改名为.net组，现在名为MS Tech组。\n" +
                    "\n" +
                    "    技术路线：\n" +
                    "\n" +
                    "    一、Python\n" +
                    "\n" +
                    "      1.python爬虫,数据提取,清洗,数据测试；\n" +
                    "\n" +
                    "      2.云计算(windows azure平台)；\n" +
                    "\n" +
                    "      3.大数据；\n" +
                    "\n" +
                    "      4.人工智能和人机交互。\n" +
                    "\n" +
                    "    二、Unity3D\n" +
                    "\n" +
                    "      1.开发创建诸如三维视频游戏、建筑可视化、实时三维动画等.\n" +
                    "\n" +
                    "      2.3DMAX建模\n" +
                    "\n" +
                    "      3.游戏UI\n" +
                    "\n" +
                    "    千里之行始于足下，在这里（9#507B）你能一步一个脚印地成长为别人眼中的大神。未来的路，用代码铸造。");
        }//微软
        if (i==1) {
            viewHolder.title.setText("算法组");
            viewHolder.content.setText("      算法组主要学习方向为人工智能、机器学习，学习地点为9栋505，指导老师为徐科老师。\n"+
                    "     算法组积极参与各种比赛，在大学生创新创业比赛中，申请到了国家级的创新项目，在新思路的内部比赛中，算法组分两组皆获得二等奖。历届的优秀学长有：12届孟祥路（去了阿里巴巴），13届刘兴旺（研究生），14届郝江伟 梁栋屹（出国留学）。欢迎各位萌新加入新思路算法组。");
        }//算法组
        if (i==2){
            viewHolder.title.setText("设计组");
            viewHolder.content.setText("用鼠标撬开脑洞拓展思维\n" +
                    "\n" +
                    "      UI(User Interface)，即用户界面。UI设计是指软件的人机交互、操作逻辑、界面美观的整体设计，主要包含交互设计和视觉设计两个方面。\n" +
                    "      新思路设计组，致力于Web、iOS、Android等的界面设计。我们是前端的开始，是后台的包装，我们用鼠标撬开脑洞拓展思维，为产品汪、运营喵和程序猿打造一场“视觉盛宴”。你，会是下一个UID(设计狮)么？");
        }//设计组
        if (i==3){
            viewHolder.title.setText("前端组");
            viewHolder.content.setText("把技术和设计完美结合\n" +
                    "\n" +
                    "玩技术的都愿意玩“深”的技术，玩设计的又不愿弄脏自己的手，\n" +
                    "但是最终能把技术和设计完美结合在一起要靠前端工程师。\n" +
                    "除了目前浏览器、服务器、移动端上的应用开发技术外，未来前端也会出现新的应用场景，例如VR、物联网Web化、Web人工智能等。\n" +
                    "这些虽然听着比较远，但一旦到来就会很快被使用，\n" +
                    "所以前端不仅自身发展快，推广使用也极其迅速\n" +
                    "到前端组来，就是和小伙伴一起做指导老师都不懂的东西。\n" +
                    "前端，快速入门，好找工作。\n" +
                    "这里还有热心的学长学姐为你指点迷津，我们在508等你");
        }//前端组
        if (i==4){
            viewHolder.title.setText("企划组（行政）");
            viewHolder.content.setText("一言以蔽之，激发创意\n" +
                    "\n" +
                    "企划组(行政)\n" +
                    "同学，你了解企划吗?\n" +
                    "企划是一种程序，本质，上是运用脑力的理性行为，是针对未来要发生的事情的当前决策，即企划是预先决定做什么， 何时做，如何做，谁来做。一言以蔽之，激发创意，有效地运用手中有限的资源，选定可行的方案，达成预定目标或解决某-难题，这就是企划。\n" +
                    "或许你有许多天马行空的idea,或许你是管理方面的一把好手，也许你还想锻炼自己的决策能力…计算机科学学院的的新思路团队有着优良的学习环境、齐备的硬件条件、 优秀的指导教师队伍，这里是展现你的才华，释放你的激情的最佳平台。\n" +
                    "无论是日常管理，还是特殊事件活动，我们期待你的表现哦!");
        }//企划组
        if (i==5){
            viewHolder.title.setText("产品组");
            viewHolder.content.setText("产品组简介：\n" +
                    "\n" +
                    "产品组于2016年由罗鲣学长（现就职于斗鱼TV）创立，指导老师为夏梦老师，主要活动区域为9#411。\n" +
                    "\n" +
                    "产品组旨在培养有自己风格特色的产品人，主要培养方向为思维方式、基础美感、基础用户心理、简单数据分析等，主要学习工具有office系列、Xmind以及MD语言……用以编写文档、流程把控等，Axure、mockplus、Sketch……用以制作原型。\n" +
                    "\n" +
                    "现有成果：\n" +
                    "即记：方便快捷的记账软件\n" +
                    "熊孩子倒计时：有趣的界面使得计时不再单调\n" +
                    "杏林医访：励志打造良好的医患交流平台\n" +
                    "新思路官方公众号：展示你所不知道的新思路实验室\n" +
                    "……");
        }//产品组
        if (i==6){
            viewHolder.title.setText("IOS组");
            viewHolder.content.setText("组内简介：本组于2012年成立，并在近几年不断发展。组内目前由夏梦老师及孙翀老师负责指导并提供帮助。\n" +
                    "\n" +
                    "发展方向：目前主要着手于应用类软件开发，组内技术栈也涉及到很多有趣实用的内容，从操作系统、编程语言的掌握、UI、多线程、网络编程到不断更新发展的前沿热门技术和语言等的学习。\n" +
                    "\n" +
                    "已有成果：\n" +
                    "iFamily-针对家庭内部沟通与交流的专属App\n" +
                    "iRelief-针对于自然灾害及意外事故处理\n" +
                    "熊孩子倒计时\n" +
                    "小红花-专属孩子的习惯养成App\n" +
                    "Garbage classification system-基于机器学习的垃圾智能分类处理系统\n" +
                    "……\n" +
                    "\n" +
                    "组内福利：团队内会有很多参加比赛的机会，拿学分，拿奖项，更可以通过成员间的分工协作，做出属于你们自己的产品。组内不但提供部分设备以及相当的参考书籍，另在每年寒暑假会有机会和组内人员一起参加苹果夏令营和冬令营，是你大学生活里不容错过的出去玩耍和学习的机会。另外本校的iOS Club在大家的共同努力下也正式成立啦，更多惊喜等你开启。");
        }//IOS
        if (i==7){
            viewHolder.title.setText("Geek组");
            viewHolder.content.setText("Geek们的聚集地\n" +
                    "\n" +
                    "“虚掩着的门是一种挑衅，锁着的门是一种侮辱。”\n" +
                    "——黑客与画家\n" +
                    "\n" +
                    "极客组是Geek们的聚集地，我们热爱DIY，敢于尝试创新，任何技术上的难题都不会轻易妥协。我们也喜欢游走在网络的安全功防中，服务运维是我们的拿手好戏。优美的代码，谱写轻快的篇章，白天不懂夜的黑，这就是我们存在的意义。\n" +
                    "目前组内有四大方向:开发，AI/算法，PM，安全\n" +
                    "获得奖项：\n" +
                    "1. 2017年“湖北省第二届网络安全技术竞赛”二等奖\n" +
                    "2. 2017高校网络信息安全运维挑战赛 华中区第四名\n" +
                    "3. 2018年360hackaday决赛前十\n" +
                    "组内成果：\n" +
                    "1. iOS10越狱的Mac移植\n" +
                    "2. 可视化的树的遍历\n" +
                    "3. C语言编写Lisp的解释器\n" +
                    "4. 云打印\n" +
                    "5. HACK-Running小游戏\n" +
                    "6. GTA自动驾驶\n" +
                    "……\n" +
                    "更多详细信息请戳Geek组招新网站：\n" +
                    "https://newthread-geek.github.io");
        }//geek
        if (i==8){
            viewHolder.title.setText("CPP组");
            viewHolder.content.setText("学习方向：服务器、游戏开发（基于Unity）、机器人开发。\n" +
                    "学习阵营：九栋505教室\n" +
                    "参加并获奖比赛：全国机器人锦标赛、蓝桥杯个人赛和团体赛、服务外包大赛、计算机设计大赛、NT挑战杯……\n" +
                    "该年度获奖：全国机器人锦标赛一等奖、蓝桥杯个人赛全国二等奖、蓝桥杯团体赛省三等奖\n" +
                    "2014届毕业生代表：陈磊（去向腾讯），马延斌（去向百度）");
        }//CPP
        if (i==9){
            viewHolder.title.setText("DB");
            viewHolder.content.setText("      DB组的征途是星辰大海\n" +
                    "\n" +
                    "      DB 团队是一支对数据充满兴趣，努力钻研的队伍。致力于为系统打下一个坚实的基础。DB组的学习地点在507B教室，主要学习方向是数据库和Python，在初期的时候，以数据库的学习为主，在掌握基本知识和技能之后开始Python的学习，分为三个方向，PythonWeb开发、数据挖掘和基于树莓派的开发，每位同学根据自己的兴趣选择学习内容。\n" +
                    "      DB组参加过许多比赛，并且取得过很好的成绩，《口语练练》项目获得蓝桥杯省级二等奖、《team world》项目获得Imagine Cup校级二等奖，同时还负责组织新思路的同学参加计算机设计大赛。\n" +
                    "      14级行政组长柳真目前在华南理工大学读研，技术组长程恒在苏宁从事Java开发，翁润雨学长在美团从事前端开发，还有许多的学长学姐在公司或者学校深造自己。\n" +
                    "      发现数据之美，DB组的征途是星辰大海，等待着你的加入。");
        }//DB
        if (i==10){
            viewHolder.title.setText("Android组");
            viewHolder.content.setText("      Google在互联网的发展已经走过了十年，从搜索巨人到全面的互联网渗透，Google服务已经成为连接用户和互联网的重要纽带，而Android平台手机将无缝结合这些优秀的Google服务，新思路的Android组正是以Java为基础，按照Google的规范开发我们自己的APP，采取团队合作的方式，在交流与合作中提升软件操作体验，提高自身编程能力与思维。\n" +
                    "      Android组集中在9栋411，环境舒适，学习资源丰富，欢迎广大学子随时进行参观。目前有大三学子6名，大二学子5名，而本次秋招主要针对于大二学子，要求具备一定的Java、android编程基础和自主编程能力，且时间充裕能在实验室共同学习。有兴趣的话，就来加入我们吧！");
        }//android
        if (i==11){
            viewHolder.title.setText("JavaEE");
            viewHolder.content.setText("      Java一统天下 <(￣︶￣)>\n" +
                    "\n" +
                    "      JavaEE组主要学习 Java基础、JavaWeb，JavaEE等\n" +
                    "\n" +
                    "       ~(￣▽￣)~*学完了你就可以干这些：\n" +
                    "\n" +
                    "      进行 Java企业级应用的后台开发，网页后台，APP后台等开发系统平台、与其它团队联合开发大型综合多用途性系统\n" +
                    "      当然你也可以参加蓝桥杯，达内杯、服务外包大赛等等，国奖在召唤你(/ω＼)\n" +
                    "\n" +
                    "      虽然PHP是最好的语言（手动狗头），但Java是近20年应用最广，使用度最高的语言（没有之一，不怂 |ω・）） 事实证明Java的人才需求市场目前是最大的，写Java的程序员是最多的。很多知名的互联网公司（网易，美团，阿里，微博，IBM，google等等）主要业务都用Java实现。越来越多的公司抛弃了PHP，投入Java的怀抱。\n" +
                    "\n" +
                    "      学长学姐们在9#508划水，欢迎加入我们，Java一统天下 <(￣︶￣)>");
        }//JAVAEE
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 12;
    }
    class LinearViewholder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;
        public LinearViewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.intro_item_title);
            content = itemView.findViewById(R.id.intro_content);
        }
    }
}
