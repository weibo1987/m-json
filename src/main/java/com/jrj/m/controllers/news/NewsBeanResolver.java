package com.jrj.m.controllers.news;
import com.jrj.m.model.news.News;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.paramresolver.ParamMetaData;
import net.paoding.rose.web.paramresolver.ParamResolver;
/**
 * 
* @ClassName: NewsBeanResolver
* @Description: TODO
* @author ping.lv ping.lv@jrj.com.cn
* @date 2015年1月21日 下午2:39:51
*
 */
public class NewsBeanResolver implements ParamResolver {

    @Override
    public Object resolve(Invocation inv, ParamMetaData metaData) throws Exception {
        for (String paramName : metaData.getParamNames()) {
            if (paramName != null) {
                News news = new News();
                String iiid = inv.getParameter("iiid");
                String title = inv.getParameter("title");
                String intro = inv.getParameter("intro");
                if(iiid != null && !"".equals(iiid))
                {
                	news.setIiid(new Long(iiid).longValue());
                }
                news.setTitle(title);
                news.setIntro(intro);
                return news;
            }
        }
        return null;

    }

    @Override
    public boolean supports(ParamMetaData metaData) {
        return News.class == metaData.getParamType();
    }

}
