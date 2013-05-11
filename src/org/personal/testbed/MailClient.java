package org.personal.testbed;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class MailClient {

    public static void main(String[] args) {

        testJoiner();

    }

    private static void testJoiner() {
        List<String> strings = Lists.newArrayList("A1", "A2", "A3", null);
        String joiner = Joiner.on("--").useForNull("null").join(strings);

        joiner = Joiner.on('*').skipNulls().join(strings);

        System.out.println(joiner);
    }

/*    private void sendEmail() {
        HtmlEmail mail = new HtmlEmail();
        mail.setHostName( EXCHANGE_SERVER );
        mail.setFrom( fromAddress, fromName );
        mail.addTo( toAddress );
        mail.setSubject( subject );

        //set the alternative message
        mail.setTextMsg("Your email client does not support HTML messages");

        mail.setHtmlMsg(msg);

        return mail;
    }
*/
}
