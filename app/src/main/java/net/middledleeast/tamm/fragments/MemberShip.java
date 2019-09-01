package net.middledleeast.tamm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import net.middledleeast.tamm.R;


public class MemberShip extends Fragment {
    Button accept;
    TextView textmemberaccount ;


    Toolbar toolbar;
    LinearLayout imageView;
    public static String  TERMS =
            "1- General Terms & Conditions:\n" +
            "\n" +
            "1.1- The word of Tamm is referred to as (Tamm Assistance Services for Visitors Company) , including the website , Mobile site , Profiles through Social Media Channels , and Smartphone's applications for IOS , Android , Window is incorporated all over the world As we care about your rights, kindly review these Terms and Conditions before using the app and (Tamm) reserves the rights to change the Terms and Conditions from time to time at its sole discretion and your use of the Site will be subject to the most current version of the terms posted on the Site at the time of such use. We recommend that you read through the Terms and Conditions from time to time so that you can be sure that you are aware of the latest version.\n" +
            "\n" +
            "2- Agreement between you and Tamm Co.\n" +
            "\n" +
            "2.1- By accessing and using the website or application, you agree to accept without Modification, limitation or qualification, the terms and conditions contained herein (Agreement).\n" +
            "\n" +
            "2.2- You represent and warrant that you Process the legal right to enter into this agreement and to use the website and mobile application in accordance with all Terms & Conditions herein.\n" +
            "\n" +
            "3- Acceptable use\n" +
            "\n" +
            "3.1- When using the website and the application you declare and agree to:\n" +
            "\n" +
            "3.2- Use them Solely to determine the availability of Products and services offered on the website and mobile applications to assist you to make legitimate reservations or transact business with us\n" +
            "\n" +
            "3.3- Use the website and mobile applications only for Personal, non-commercial use.\n" +
            "\n" +
            "3.4- Use the website and mobile applications Services to make legitimate reservations.\n" +
            "\n" +
            "3.5- You are at least 21 years old and you possess the legal Authority to create binding legal obligations.\n" +
            "\n" +
            "3.6- You will inform such other persons about the terms of use that apply to the reservations you have made on their behalf, including all rules and restrictions applicable therefore.\n" +
            "\n" +
            "3.7- Advising such other persons not to make false reservations or any reservations in anticipation of demand the website or mobile application may cancel without notice, all confirmations associated with multiple reservations to one or more destination on or about the same date.\n" +
            "\n" +
            "3.8- You don’t have authority to deface, alter or interface with the front end of the website, mobile application or the underling middledleeast company software code.\n" +
            "\n" +
            "3.9- You don’t have authority to take any action that may impose and reasonable, unreasonable or disproportionately large load on the website or related middledleeast company infrastructure.\n" +
            "\n" +
            "3.10- You don’t have authority to take any action that may impose and reasonable, unreasonable or disproportionately large load on the website or related middledleeast company infrastructure.\n" +
            "\n" +
            "3.11- Not to do anything which will or would damage interfere with disrupt access to interrupt or impair the functionality of the materials available on this website or mobile application.\n" +
            "\n" +
            "3.12- By using Tamm Website or Mobile application to access your services and advantages you accept and agree to be bound by the terms and Condition herein this section in addition to the rest of these Terms of Services.\n" +
            "\n" +
            "3.13- It is not allowed to you to upload any materials or ads contains any Viruses or Commercial Advertisements have been designed to destroy or interrupt using your Functional advantages has been given to you for using our Products and Services.\n" +
            "\n" +
            "3.14- Violation for this agreement or any applicable legislation in any other manner it will be protected by law or by rights of privacy and publicity.\n" +
            "\n" +
            "3.15- Hosting, modifying, Publishing, Transmitting, updating or Sharing information or Trademark have been owned by the company should Exposes you to face law and authorize the company to take legal actions against you.\n" +
            "\n" +
            "4- Modification of Terms\n" +
            "\n" +
            "4.1- Tamm Company Tries to ensure that the information contained on the website and application is as accurate as possible However, inaccuracies may arise from time to time and the Company accept to not have any responsibility for any errors it might will happen in the Present time or in the Future.\n" +
            "\n" +
            "4.2- The website and application contain information about the products & Services had been provided by Tamm Company and it was Provided in good faith by using app you agree that you have acknowledge that Application and website may update or change the terms & Conditions and Customers care Policy and it will be effective once it will be post on the website or in the application.\n" +
            "\n" +
            "4.3- This Changes it will not have any affectivities on existing contractual arrangement made through the website or the application.\n" +
            "\n" +
            "5- Conditions of Carriage\n" +
            "\n" +
            "5.1- The Carriage of Passengers and their baggage by air will be Subject to the conditions of Carriage of the carrier concerned.\n" +
            "\n" +
            "5.2- Tamm Company is responsible about your baggage from door to airport before or same time of your leaving and we guarantee safety of you and your family luggage.\n" +
            "\n" +
            "6- Conditions of hotels\n" +
            "\n" +
            "6.1- The booking process is subject to the terms and conditions of hotels providers and applies to TAMM company and users of the site and the mobile application.\n" +
            "\n" +
            "6.2- TAMM Company is not responsible for any errors in bookings, changes in booking or cancellation from the hotel’s providers.\n" +
            "\n" +
            "7- Membership Registration\n" +
            "\n" +
            "7.1- A Guest Member is a user of our application who is invited to use our services on a trial basis.\n" +
            "\n" +
            "7.2- Tamm Member is a user of the application who has registered for the app by logging in with their user name and password.\n" +
            "\n" +
            "7.3- As a Tamm Member or Guest Member (referred to as 'Member' throughout these terms and conditions) when visiting or using the Site or application and/or any content or materials available, you agree to be bound by these terms which form a legally binding agreement between us (the 'Contract’).\n" +
            "\n" +
            "8- Our Services\n" +
            "\n" +
            "8.1- Services we provide via the App include:\n" +
            "\n" +
            "8.2- The provision of access to reservations and other content we publish on our App, website and Social Media Channels.\n" +
            "\n" +
            "8.3- The facility to search for Suppliers and Partnered Suppliers and where applicable book services with said Suppliers.\n" +
            "\n" +
            "8.4- The ability to request to be updated on specific information.\n" +
            "\n" +
            "8.5- The ability to brief in a new request to the lifestyle concierge service.\n" +
            "\n" +
            "8.6- Such other services as we elect to provide from the App from time to time (together the ‘Services’).\n" +
            "\n" +
            "8.7- The App also has contact telephone numbers for Members to be able to call and speak to a Lifestyle Call Centre. Please note that telephone calls to Tamm Company may be monitored for training and quality control purposes.\n" +
            "\n" +
            "8.8- We reserve the right at any time and from time to time to modify the Services we provide and to ic_add or remove content.\n" +
            "\n" +
            "8.9- Where there are specific terms and conditions for different Services provided via the App, these are outlined below:\n" +
            "\n" +
            "9- Dining and restaurants\n" +
            "\n" +
            "9.1- When a booking is made for you (the Member) with a (Tamm), you will be bound by the Tamm’s terms and conditions including our cancellation policy.\n" +
            "\n" +
            "9.2- These terms and conditions may be included in your booking confirmation but can also be found on the App of Tamm.\n" +
            "\n" +
            "9.3- (Tamm) reserves the rights to deny restaurant reservation requests from Members if Members repeatedly fail to show up for bookings or violate Tamm’s cancellation policies.\n" +
            "\n" +
            "9.4- You acknowledge that benefits with (Tamm) are subject to availability and may change from time to time without notice.\n" +
            "\n" +
            "9.5- Tamm company not responsible about anything with be provide from providers\n" +
            "\n" +
            "10- Entertainment and travels\n" +
            "\n" +
            "10.1- All tickets are subject to availability (Depending for the Country Tamm has agreed with).\n" +
            "\n" +
            "10.2- The agreement is between you (the Member) and the Supplier when booking tickets via the lifestyle concierge service.\n" +
            "\n" +
            "10.3- Once you have given Tamm Authorisation to purchase tickets, you will be liable to pay the price of the tickets in full.\n" +
            "\n" +
            "10.4- Once tickets are confirmed there will be no refunds or exchanges.\n" +
            "\n" +
            "10.5- Please always check both the booking confirmation and tickets you receive and notify (Tamm) of any discrepancies immediately. We will endeavour to solve any problem caused by an error made by (Tamm), but in other cases we will assist without being held responsible financially.\n" +
            "\n" +
            "10.6- Tickets will be considered restricted view only if specified by the Supplier, box office, venue and/or on the physical tickets. (Tamm) will advise if any tickets have restricted view prior to purchase.\n" +
            "\n" +
            "10.7- The method and company used for ticket delivery will be selected by the Supplier and (Tamm). Often tickets will be sent via secure post or courier which will require a signature upon delivery. When delivery is attempted, if you are unavailable you will need to collect from the local sorting office of (Tamm) or where appropriate, organise a re-delivery directly with the courier company. (Tamm) will offer support with any deliveries but cannot be held responsible for errors not caused by us.\n" +
            "\n" +
            "10.8- Tickets are usually delivered 5-7 days before the event, with the exception of theatre tickets, which are sent immediately after the booking is made. The date upon which tickets are released is controlled by the promoters of the event, who often delay delivery in order to reduce both fraudulent activity and the risk of tickets being misplaced.\n" +
            "\n" +
            "10.9- When tickets are purchased through secondary ticket agents, the Supplier will make every effort to deliver them several days before for the event. However, they reserve the right to deliver tickets just 24 hours in advance and on rare occasions may arrange for you to meet a representative at the venue.\n" +
            "\n" +
            "10.10- It is your responsibility to advise (Tamm) of any change of address which may affect your booking, or if you plan to be away in the days leading up to the event.\n" +
            "\n" +
            "10.11- If tickets are misplaced and originally purchased through a face value box office, tickets can often be duplicated. It is unlikely that tickets will be re-issued prior to the event date and will therefore be a box office collection. In order to collect tickets in this way, the original card holder and the card that was used to purchase the tickets need to be present. Letters of Authorisation are subject to the venue box office’s discretion and in some instances will not be accepted.\n" +
            "\n" +
            "10.12- If tickets purchased through secondary ticket agents are misplaced, it is extremely difficult to arrange duplicates or box office collection, since they usually need to be collected by the individual who originally purchased the tickets. If this occurs, we will try our best to arrange for duplicates or collection, but if we are unable to do so we cannot provide a refund.\n" +
            "\n" +
            "10.13- If you find you are unable to attend and would like advice on re-selling your tickets, please contact (Tamm) for further information.\n" +
            "\n" +
            "10.14- While we will endeavour to update you of any changes made to the date or time of your event, we cannot take responsibility to inform you if an event is cancelled or provide details if it is rearranged. Where tickets are purchased through the secondary market, tickets will usually be valid for the rescheduled date. If you are not able to Make the new date; refunds will be made at the Supplier’s discretion. Ten will not be held responsible for any additional financial outlay, such as for accommodation or transport, that occurs as a result of a cancelled or rescheduled date.\n" +
            "\n" +
            "10.15- For tickets purchased direct through the box office if the event is cancelled, you will receive a full refund direct from the box office. If the event is postponed, refunds will not be given until a new date has been rescheduled – if you cannot make this new date, then you are entitled to a full refund, upon ticket provider term and conditions.\n" +
            "\n" +
            "10.16- Please ensure you check on your statement that your card has been debited for the amount of your tickets within 3-5 days of booking. If this is not the case then please calls (Tamm) to look into this.\n" +
            "\n" +
            "10.17- Event timings are always subject to change and (Tamm) will do its best to advise you of these but there can be last minute changes made by the promoters.\n" +
            "\n" +
            "10.18- In the extremely rare event that a Box Office supplier or secondary market ticket supplier goes bankrupt or does not deliver the tickets, the concierge service cannot accept liability for the loss of tickets. The terms and conditions of the supplier apply and you, the member, will have been made aware of these terms and conditions and accepted them at the point of purchase. However, in such a difficult situation, the concierge service will always act on behalf of the member in the member’s best interests to try to remedy the situation. As a minimum, this will include:\n" +
            "\n" +
            "10.19- Advising the member of the Chargeback process, if they have paid by debit or credit card, whereby Visa / MasterCard / Amex go to the vendor to try to re-coup the money. Note that there is a time limit within which this chargeback process is applicable.\n" +
            "\n" +
            "10.20- Sourcing alternative tickets to match the original order as closely as possible in terms of location, price and date, if the member chooses to purchase new tickets.\n" +
            "\n" +
            "11- Deposits and Payment\n" +
            "\n" +
            "11.1- Deposits are non-refundable.\n" +
            "\n" +
            "11.2- Payment of a deposit enables us to hold a reservation for you but does not guarantee the price.\n" +
            "\n" +
            "11.3- The price can only be guaranteed once we receive full payment and tickets and/or other travel documents have been issued. You will be advised of the current price of the holiday that you wish to book before your contract is confirmed.\n" +
            "\n" +
            "11.4- If payment for your booking is made by credit card, an administration fee may be payable.\n" +
            "\n" +
            "11.5- After full payment, if we are your Booking Agent or Airline Ticket Agent, the conditions of the contract with your airline or other Supplier of travel services may permit them to increase the cost of your arrangements. We will pass on the details of Any such increase to you and we will collect the additional amounts from you on behalf of the airline or other Supplier of travel services (as their agent).\n" +
            "\n" +
            "11.6- If we have arranged a Package for you, changes in transportation costs including the cost of fuel, taxes, fees and exchange rates mean that the price of your Package may change after you have paid in full. You will not be charged for any increase equivalent to 2% or less of the price of your Package. You will be charged for any amount over and above that. No price increases will be charged to you in the period of 30 days or less prior to your departure date.\n" +
            "\n" +
            "12- Documentation\n" +
            "\n" +
            "12.1- Our general practice is to send documents to our members electronically whenever possible.\n" +
            "\n" +
            "12.2- We reserve the right to charge an administration fee should you make a request for such documents to be sent as hard copy.\n" +
            "\n" +
            "12.3- Your travel documents are valuable and should be safeguarded as if they were cash. It is not always possible to replace travel documents in the case of loss, theft, damage and so on.\n" +
            "\n" +
            "13- Your Agreement with Us\n" +
            "\n" +
            "13.1- By finalizing your arrangements with us, you are accepting that these terms and conditions and the terms and conditions of any contract made with any other suppliers of travel services within your arrangements apply to your booking and your travel arrangements. You also consent to our processing personal information about you and other members of your party for the purposes of performing our obligations in relation to your booking (which includes, but is not limited to, giving your personal information to airlines, other suppliers of travel services and public authorities (such as customs or immigration) where this is required for the fulfilment of your arrangements).\n" +
            "\n" +
            "13.2- If you travel outside the European Economic Area, controls on data protection may not be as strong as the legal requirements in this country. If we cannot pass this information to the relevant suppliers of travel services, whether in the EEA or not, we will be unable to provide your booking. In making your booking, you consent to this information being passed on to the relevant persons. Your contract with us is subject to the laws and jurisdiction of Kuwait.\n" +
            "\n" +
            "14- If You Cancel Your Travel Booking\n" +
            "\n" +
            "14.1- If you cancel your arrangements, you may be entitled to a partial refund. In addition to any cancellation fees set out in any supplier of any of our Service's terms and conditions (which may be 100% of the cost of the Service arrangements), we will also charge the cancellation fees outlined on your receipt. We need to receive written notification of cancellation and your original ticket/voucher from you before any refund can be considered.\n" +
            "\n" +
            "14.2- If you decide to cancel arrangements before the balance due date, any deposits paid are non-refundable.\n" +
            "\n" +
            "14.3- Refunds will only be paid to you once we have received the funds back from the relevant supplier of services. Generally, flight tickets cannot be refunded if they are partially used.\n" +
            "\n" +
            "14.4- If the reason for your cancellation is covered under the terms of your travel insurance policy, you may be able to reclaim your cancellation charges through your insurer.\n" +
            "\n" +
            "14.5- If the person paying for the booking (the paying customer) is different from the travelling customer, and the paying customer wishes to cancel or withdraw the funding of any booked tickets, (Tamm) will notify the travelling customer of the paying customer's funding withdrawal and give the travelling customer the option of continuing with the booking, subject to payment of the full cost of the travelling customer’s booked ticket by the travelling customer. If, following this notification, the travelling customer does not pay the full cost of his or her booked ticket, the booked ticket will be cancelled and the amount paid by the paying customer in relation to the Booked ticket will be refunded to the paying customer (subject to the relevant supplier of travel services’ terms and conditions and the provisions of previous paragraph of these terms and conditions). Any airline costs/charges associated with the cancellation will be deducted from the refund due to the paying customer. (Tamm) will not charge a cancellation fee in these circumstances.\n" +
            "\n" +
            "15- Passports, Visa and Immigration Requirements\n" +
            "\n" +
            "15.1- It is your responsibility to fulfil the passport, visa and other immigration requirements applicable to your itinerary. You should confirm these with the relevant High Commissions, embassies and/or consulates. We do not accept any responsibility if you are unable to travel due to not complying with any such requirements.\n" +
            "\n" +
            "16- Insurance\n" +
            "\n" +
            "16.1- Travel insurance is an important part of your arrangements. You should take out adequate insurance for the duration of your journey. Travel insurance is a mandatory element of some travel arrangements.\n" +
            "\n" +
            "17- At Home\n" +
            "\n" +
            "17.1- Upon the member’s request (Tamm) shall exercise reasonable endeavours to offer the member information on services or preferred suppliers that have been vetted to high standards, for example by verifying their insurance, qualifications and professional memberships. Not only that, but additionally (Tamm) will take every effort in obtaining feedback on previous work carried out by the suppliers. However, by using the information given by (Tamm), members are deemed to be responsible for, and shall use, their own skill and judgement as to the value and suitability of such information and suggestions in relation to the suppliers or services.\n" +
            "\n" +
            "17.2- (Tamm) disclaims all responsibility for any loss or damage caused by the Suppliers or for their poor performance.\n" +
            "\n" +
            "17.3- In no event shall (Tamm) be liable for any injury, damage, delay or negligence by a Supplier or Member in connection with any of the services or products suggested.\n" +
            "\n" +
            "17.4- The Member’s contractual relationship with respect to all service arrangements suggested by (Tamm) shall be specifically with the Supplier, and any claims or losses will be between the Member and the Supplier in accordance with the terms of the Supplier’s contractual agreement.\n" +
            "\n" +
            "17.5- The Supplier’s charges for the performance of services will at all times be payable by the member, unless it has been agreed otherwise.\n" +
            "\n" +
            "17.6- Ten will not be liable to the member for any direct, indirect, special, incidental, consequential, punitive or exemplary damages (including but not limited to loss of business opportunity, profits or savings) arising in any way related to the use of (Tamm’s services).\n" +
            "\n" +
            "18- Fair Usage Policy\n" +
            "\n" +
            "18.1- The following Policy relates to your use of the concierge service provided by (Tamm) Lifestyle Concierge. It is designed to make sure we can provide you with a service that is trustworthy, fast and reliable.\n" +
            "\n" +
            "18.2- You must make sure that any use of the concierge service, by yourself or anyone else via your account, complies with this Policy. If you (or anyone else using the concierge service via your account) breach this Policy, we may:\n" +
            "\n" +
            "18.3- Give you a notice to stop or moderate the unacceptable use(s).\n" +
            "\n" +
            "18.4- Terminate or suspend your concierge service, with or without notice as we consider appropriate, under the Terms.\n" +
            "\n" +
            "18.5- You must not use the concierge service for the purpose of providing a service of support to anyone other than immediate family members or friends.\n" +
            "\n" +
            "18.6- There is limit on the usage of our online concierge service. However, if we feel that your activities are so excessive that other customers are detrimentally affected, we may give you a written notice (by email or otherwise). In extreme circumstances, if the levels of activity do not immediately decrease after the warning, we may terminate or suspend your account.\n" +
            "\n" +
            "18.7- You’re responsible for all use of the concierge service through your account and for any breach of this Policy whether an unacceptable use occurs or is attempted, whether you knew or should have known about it, whether or not you carried out or attempted the unacceptable use alone, contributed to or acted with others or allowed any unacceptable use to occur by omission.\n" +
            "\n" +
            "19- Complaints\n" +
            "\n" +
            "19.1- Please contact (Tamm) Call Centre immediately should you be dissatisfied with any aspect of the service you receive and we will undertake to look into the issue within two working days of receipt of notification and to respond to the Member as soon as reasonably practicable.\n" +
            "\n" +
            "19.2- We will not be responsible for the failure of any Supplier to provide any goods or services booked on your behalf or the negligence of the third party providing them. However, we will make reasonable effort to assist in the resolution of any such issue.\n" +
            "\n" +
            "20- Disclaimer\n" +
            "\n" +
            "20.1- (Tamm) hereby grants visitors to this World-Wide Application access to them accounts conditional upon your agreement to accept the application of the laws of Kuwait to govern matters between us in relation to this App and you agree to indemnify us and not hold us liable for the foreseeable result of any actions you may take based on the information contained herein.\n" +
            "\n" +
            "21- Personal data\n" +
            "\n" +
            "21.1- TAMM company has been completely not responsible for any mistake in the user users, resulting unsuccessful in bookings (airflight or hotels) in order of that failure of the service and the user is fully responsible for this mistake.\n" +
            "\n" +
            "22- Notices\n" +
            "\n" +
            "22.1- The notice or any other communication under this Agreement or related thereto must be in writing and delivered personally or sent by regular mail, fax or e-mail to TAMM company that has been provided with our website main branch (www.apptamm.com).\n" +
            "\n" +
            "23- Governing Law and Jurisdiction\n" +
            "\n" +
            "23.1- This agreement is governed by and shall be construed in accordance with Kuwait Law.\n" +
            "\n" +
            "23.2- The courts of Kuwait have exclusive jurisdiction to hear and decide any suit action or proceedings and to settle any disputes which may arise out of or in connection with this Agreement and for these purposes each party irrevocably submits to the jurisdiction of the courts of Kuwait.\n" +
            "\n" +
            "End Of Terms And Conditions";

    //private static final String urlmember ="http://egyptgoogle.com/backend/membership/membership.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_ship, container, false);
        accept = view.findViewById(R.id.btn_register_signup);
        textmemberaccount = view.findViewById(R.id.textView2);
        toolbar = view.findViewById(R.id.welcome_toolbar);
        imageView = view.findViewById(R.id.back_pressed);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new PlansFragment())
                        .addToBackStack( "MemberShip" ).commit();
            }
        });

        textmemberaccount.setText(TERMS);
      //  getmemberaccount();


        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new MemberShipPlan())
                        .addToBackStack( "MemberShip" ) .commit();
            }

        });
        return view;
    }





//    private void getmemberaccount() {
//        StringRequest stringRequest=new StringRequest(Request.Method.GET, urlmember, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject=new JSONObject(response);
//                    JSONArray array=jsonObject.getJSONArray("memberbody");
//                    for (int i=0; i<array.length(); i++ ){
//                        JSONObject ob=array.getJSONObject(i);
//                        final String member = ob.getString("memberbody");
//
//
//
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
//        requestQueue.ic_add(stringRequest);
//
//    }

   }

