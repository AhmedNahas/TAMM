package com.Tamm.Hotels.wcf;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.5.6.0
//
// Created by Quasar Development 
//
//---------------------------------------------------


public class Enums {

    public enum HotelRatingInput {
        
        All(0),

        OneStarOrLess(1),

        TwoStarOrLess(2),

        ThreeStarOrLess(3),

        FourStarOrLess(4),

        FiveStarOrLess(5),

        OneStarOrMore(6),

        TwoStarOrMore(7),

        ThreeStarOrMore(8),

        FourStarOrMore(9),

        FiveStarOrMore(10);

        private int code;

        HotelRatingInput(int code) {
            this.code = code;
        }

        public static HotelRatingInput fromString(String str) {
            if (str.equals("All"))
                return All;
            if (str.equals("OneStarOrLess"))
                return OneStarOrLess;
            if (str.equals("TwoStarOrLess"))
                return TwoStarOrLess;
            if (str.equals("ThreeStarOrLess"))
                return ThreeStarOrLess;
            if (str.equals("FourStarOrLess"))
                return FourStarOrLess;
            if (str.equals("FiveStarOrLess"))
                return FiveStarOrLess;
            if (str.equals("OneStarOrMore"))
                return OneStarOrMore;
            if (str.equals("TwoStarOrMore"))
                return TwoStarOrMore;
            if (str.equals("ThreeStarOrMore"))
                return ThreeStarOrMore;
            if (str.equals("FourStarOrMore"))
                return FourStarOrMore;
            if (str.equals("FiveStarOrMore"))
                return FiveStarOrMore;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum OrderByFilter {
        
        PriceAsc(0),

        PriceDesc(1),

        StarRatingAsc(2),

        StarRatingDesc(3),

        TBOPreference(4);

        private int code;

        OrderByFilter(int code) {
            this.code = code;
        }

        public static OrderByFilter fromString(String str) {
            if (str.equals("PriceAsc"))
                return PriceAsc;
            if (str.equals("PriceDesc"))
                return PriceDesc;
            if (str.equals("StarRatingAsc"))
                return StarRatingAsc;
            if (str.equals("StarRatingDesc"))
                return StarRatingDesc;
            if (str.equals("TBOPreference"))
                return TBOPreference;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum HotelInfoHotelRating {
        
        All(0),

        OneStar(1),

        TwoStar(2),

        ThreeStar(3),

        FourStar(4),

        FiveStar(5);

        private int code;

        HotelInfoHotelRating(int code) {
            this.code = code;
        }

        public static HotelInfoHotelRating fromString(String str) {
            if (str.equals("All"))
                return All;
            if (str.equals("OneStar"))
                return OneStar;
            if (str.equals("TwoStar"))
                return TwoStar;
            if (str.equals("ThreeStar"))
                return ThreeStar;
            if (str.equals("FourStar"))
                return FourStar;
            if (str.equals("FiveStar"))
                return FiveStar;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum SupplementType {
        
        PerStaySupplement(0),

        PerPersonSupplement(1),

        PerRoomSupplement(2);

        private int code;

        SupplementType(int code) {
            this.code = code;
        }

        public static SupplementType fromString(String str) {
            if (str.equals("PerStaySupplement"))
                return PerStaySupplement;
            if (str.equals("PerPersonSupplement"))
                return PerPersonSupplement;
            if (str.equals("PerRoomSupplement"))
                return PerRoomSupplement;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum SupmtChargeType {
        
        Included(0),

        Addition(1),

        AtProperty(2);

        private int code;

        SupmtChargeType(int code) {
            this.code = code;
        }

        public static SupmtChargeType fromString(String str) {
            if (str.equals("Included"))
                return Included;
            if (str.equals("Addition"))
                return Addition;
            if (str.equals("AtProperty"))
                return AtProperty;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum CancellationChargeTypeForHotel {
        
        Fixed(0),

        Percentage(1),

        Night(2);

        private int code;

        CancellationChargeTypeForHotel(int code) {
            this.code = code;
        }

        public static CancellationChargeTypeForHotel fromString(String str) {
            if (str.equals("Fixed"))
                return Fixed;
            if (str.equals("Percentage"))
                return Percentage;
            if (str.equals("Night"))
                return Night;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum PolicyFormat {
        
        Text(0),

        Nodes(1);

        private int code;

        PolicyFormat(int code) {
            this.code = code;
        }

        public static PolicyFormat fromString(String str) {
            if (str.equals("Text"))
                return Text;
            if (str.equals("Nodes"))
                return Nodes;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum GuestType {
        
        Adult(0),

        Child(1);

        private int code;

        GuestType(int code) {
            this.code = code;
        }

        public static GuestType fromString(String str) {
            if (str.equals("Adult"))
                return Adult;
            if (str.equals("Child"))
                return Child;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum PaymentModeType {
        
        Limit(0),

        CreditCard(1),

        Fawry(2);

        private int code;

        PaymentModeType(int code) {
            this.code = code;
        }

        public static PaymentModeType fromString(String str) {
            if (str.equals("Limit"))
                return Limit;
            if (str.equals("CreditCard"))
                return CreditCard;
            if (str.equals("Fawry"))
                return Fawry;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum SuppChargeType {
        
        Included(0),

        Addition(1),

        AtProperty(2);

        private int code;

        SuppChargeType(int code) {
            this.code = code;
        }

        public static SuppChargeType fromString(String str) {
            if (str.equals("Included"))
                return Included;
            if (str.equals("Addition"))
                return Addition;
            if (str.equals("AtProperty"))
                return AtProperty;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum APIHotelBookingStatus {
        
        Failed(0),

        Confirmed(1),

        Cancelled(2),

        Pending(3),

        Rejected(4),

        Vouchered(5),

        CancellationInProgress(6),

        CxlRequestSentToHotel(7),

        WaitingForPayment(8),

        CancelledAndRefundAwaited(9),

        Requested(10);

        private int code;

        APIHotelBookingStatus(int code) {
            this.code = code;
        }

        public static APIHotelBookingStatus fromString(String str) {
            if (str.equals("Failed"))
                return Failed;
            if (str.equals("Confirmed"))
                return Confirmed;
            if (str.equals("Cancelled"))
                return Cancelled;
            if (str.equals("Pending"))
                return Pending;
            if (str.equals("Rejected"))
                return Rejected;
            if (str.equals("Vouchered"))
                return Vouchered;
            if (str.equals("CancellationInProgress"))
                return CancellationInProgress;
            if (str.equals("CxlRequestSentToHotel"))
                return CxlRequestSentToHotel;
            if (str.equals("WaitingForPayment"))
                return WaitingForPayment;
            if (str.equals("CancelledAndRefundAwaited"))
                return CancelledAndRefundAwaited;
            if (str.equals("Requested"))
                return Requested;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum PriceVerificationStatus {
        
        Successful(0),

        Failed(1),

        NotAvailable(2);

        private int code;

        PriceVerificationStatus(int code) {
            this.code = code;
        }

        public static PriceVerificationStatus fromString(String str) {
            if (str.equals("Successful"))
                return Successful;
            if (str.equals("Failed"))
                return Failed;
            if (str.equals("NotAvailable"))
                return NotAvailable;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum AccountBalance {
        
        Sufficient(0),

        InSufficient(1);

        private int code;

        AccountBalance(int code) {
            this.code = code;
        }

        public static AccountBalance fromString(String str) {
            if (str.equals("Sufficient"))
                return Sufficient;
            if (str.equals("InSufficient"))
                return InSufficient;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum HotelDetailsVerificationStatus {
        
        Successful(0),

        Failed(1),

        NotApplicable(2);

        private int code;

        HotelDetailsVerificationStatus(int code) {
            this.code = code;
        }

        public static HotelDetailsVerificationStatus fromString(String str) {
            if (str.equals("Successful"))
                return Successful;
            if (str.equals("Failed"))
                return Failed;
            if (str.equals("NotApplicable"))
                return NotApplicable;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum RequestStatus {
        
        Unprocessed(0),

        RequestSent(1),

        InProgress(2),

        AgentApprovalPending(3),

        PendingWithSupplier(4),

        Amended(5),

        Withdrawn(6),

        Rejected(7),

        Cancelled(8),

        NotRequested(9);

        private int code;

        RequestStatus(int code) {
            this.code = code;
        }

        public static RequestStatus fromString(String str) {
            if (str.equals("Unprocessed"))
                return Unprocessed;
            if (str.equals("RequestSent"))
                return RequestSent;
            if (str.equals("InProgress"))
                return InProgress;
            if (str.equals("AgentApprovalPending"))
                return AgentApprovalPending;
            if (str.equals("PendingWithSupplier"))
                return PendingWithSupplier;
            if (str.equals("Amended"))
                return Amended;
            if (str.equals("Withdrawn"))
                return Withdrawn;
            if (str.equals("Rejected"))
                return Rejected;
            if (str.equals("Cancelled"))
                return Cancelled;
            if (str.equals("NotRequested"))
                return NotRequested;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum AmendmentType {
        
        CheckStatus(0),

        OfflineAmendment(1),

        PriceApproved(2),

        WithdrawRequest(3);

        private int code;

        AmendmentType(int code) {
            this.code = code;
        }

        public static AmendmentType fromString(String str) {
            if (str.equals("CheckStatus"))
                return CheckStatus;
            if (str.equals("OfflineAmendment"))
                return OfflineAmendment;
            if (str.equals("PriceApproved"))
                return PriceApproved;
            if (str.equals("WithdrawRequest"))
                return WithdrawRequest;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum PriceChange {
        
        InformationRequired(0),

        Approved(1);

        private int code;

        PriceChange(int code) {
            this.code = code;
        }

        public static PriceChange fromString(String str) {
            if (str.equals("InformationRequired"))
                return InformationRequired;
            if (str.equals("Approved"))
                return Approved;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum AmendActionReq {
        
        Rename(0),

        Add(1),

        Delete(2);

        private int code;

        AmendActionReq(int code) {
            this.code = code;
        }

        public static AmendActionReq fromString(String str) {
            if (str.equals("Rename"))
                return Rename;
            if (str.equals("Add"))
                return Add;
            if (str.equals("Delete"))
                return Delete;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum RoomRequested {
        
        FirstRoom(0),

        SecondRoom(1),

        ThirdRoom(2),

        FourthRoom(3),

        FifthRoom(4),

        SixthRoom(5),

        SeventhRoom(6),

        EighthRoom(7),

        NinthRoom(8);

        private int code;

        RoomRequested(int code) {
            this.code = code;
        }

        public static RoomRequested fromString(String str) {
            if (str.equals("FirstRoom"))
                return FirstRoom;
            if (str.equals("SecondRoom"))
                return SecondRoom;
            if (str.equals("ThirdRoom"))
                return ThirdRoom;
            if (str.equals("FourthRoom"))
                return FourthRoom;
            if (str.equals("FifthRoom"))
                return FifthRoom;
            if (str.equals("SixthRoom"))
                return SixthRoom;
            if (str.equals("SeventhRoom"))
                return SeventhRoom;
            if (str.equals("EighthRoom"))
                return EighthRoom;
            if (str.equals("NinthRoom"))
                return NinthRoom;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum DateActionRes {
        
        Retained(0),

        Changed(1);

        private int code;

        DateActionRes(int code) {
            this.code = code;
        }

        public static DateActionRes fromString(String str) {
            if (str.equals("Retained"))
                return Retained;
            if (str.equals("Changed"))
                return Changed;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum AmendActionRes {
        
        Retained(0),

        Added(1),

        Deleted(2),

        Renamed(3);

        private int code;

        AmendActionRes(int code) {
            this.code = code;
        }

        public static AmendActionRes fromString(String str) {
            if (str.equals("Retained"))
                return Retained;
            if (str.equals("Added"))
                return Added;
            if (str.equals("Deleted"))
                return Deleted;
            if (str.equals("Renamed"))
                return Renamed;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum CancelRequestType {
        
        HotelCancel(0),

        CheckStatus(1);

        private int code;

        CancelRequestType(int code) {
            this.code = code;
        }

        public static CancelRequestType fromString(String str) {
            if (str.equals("HotelCancel"))
                return HotelCancel;
            if (str.equals("CheckStatus"))
                return CheckStatus;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum HotelCancelStatus {
        
        UnProcessed(0),

        Pending(1),

        InProgress(2),

        Processed(3),

        Rejected(4),

        RefundAwaited(5);

        private int code;

        HotelCancelStatus(int code) {
            this.code = code;
        }

        public static HotelCancelStatus fromString(String str) {
            if (str.equals("UnProcessed"))
                return UnProcessed;
            if (str.equals("Pending"))
                return Pending;
            if (str.equals("InProgress"))
                return InProgress;
            if (str.equals("Processed"))
                return Processed;
            if (str.equals("Rejected"))
                return Rejected;
            if (str.equals("RefundAwaited"))
                return RefundAwaited;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

    public enum HotelRating {
        
        All(0),

        OneStar(1),

        TwoStar(2),

        ThreeStar(3),

        FourStar(4),

        FiveStar(5);

        private int code;

        HotelRating(int code) {
            this.code = code;
        }

        public static HotelRating fromString(String str) {
            if (str.equals("All"))
                return All;
            if (str.equals("OneStar"))
                return OneStar;
            if (str.equals("TwoStar"))
                return TwoStar;
            if (str.equals("ThreeStar"))
                return ThreeStar;
            if (str.equals("FourStar"))
                return FourStar;
            if (str.equals("FiveStar"))
                return FiveStar;
            return null;
        }

        public int getCode() {
            return code;
        }
    }

}