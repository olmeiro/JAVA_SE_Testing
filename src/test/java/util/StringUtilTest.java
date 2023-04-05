package util;

class StringUtilTest {
    public static void main(String[] args) {
        //Manualmente:
        String result = StringUtil.repeat("hola", 3);
        System.out.println(result);
        //automatizado:
        if(!result.equals("holaholahola")){
            System.out.println("Error");
        }

        String result2 = StringUtil.repeat("hola", 1);
        System.out.println(result);
        //automatizado:
        if(!result.equals("hola")){
            System.out.println("Error");
        }
    }
}