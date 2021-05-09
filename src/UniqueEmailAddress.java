import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args){
        UniqueEmailAddress a = new UniqueEmailAddress();
        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"
        };
        System.out.println(a.numUniqueEmails(emails));
    }
    public int numUniqueEmails(String[] emails){
        //1
        Set<String> set = new HashSet<>();

        //2
        for (String email : emails) {
            String localName = makeLocalName(email);
            String domainName = makeDomainName(email);
            String convertedEmail = localName + "@" + domainName;
            set.add(convertedEmail);
        }

        return set.size();
    }
    private String makeLocalName(String email){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < email.length(); i++){
            //1
            if(email.charAt(i) == '.') continue;
            if(email.charAt(i) == '+') break;
            if(email.charAt(i) == '@') break;

            //2
            String str = "" + email.charAt(i);
            sb.append(str);
        }

        return sb.toString();
    }

    private String makeDomainName(String email){
        String substring = email.substring(email.indexOf("@") + 1);
        return substring;
    }
}
