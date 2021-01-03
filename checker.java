class checker
{
    static boolean specialchar(char c)
    {
        String check = "!@#$%^&*";
        for(int i = 0;i < check.length();i++)
        {
            char q = check.charAt(i);
            if(c == q)
                return true;
        }
        return false;
     }
    public static void main(String args[])
    {
        String use = "abcD123#";
        for(int i = 0;i < use.length();i++)
        {
            char ch = use.charAt(i);
            if(Character.isDigit(ch))
                System.out.println("Has a digit");
            if(Character.isUpperCase(ch))
                System.out.println("Has uppercase");
            if(specialchar(ch))
                System.out.println("Has special character");
        }
    }
}
