package udf;

import com.aliyun.odps.udf.UDF;

public class CompareStr extends UDF {
    // TODO define parameters and return type, e.g:  public String evaluate(String a, String b)
    //总店分店商品 禁限运打标 校验
    public Boolean evaluate(String a ,String b) {
        if(a == null || a.length()==0 || b == null || b.length()==0){
            return true;
        }
        String [] stra = a.split(",");
        for (String s : stra){
            if(!b.contains(s)){
                return true;
            }
        }

        String [] strb = b.split(",");
        for (String s : strb){
            if(!a.contains(s)){
                return true;
            }
        }
        return false;
    }

  //"sku级体积","sku级大件","sku级重量","",""


}