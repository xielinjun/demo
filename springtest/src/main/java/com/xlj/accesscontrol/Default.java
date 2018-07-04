package com.xlj.accesscontrol;

class Default {

    private String private_;

    String default_;

    protected String protected_;

    public static class DefaultInnternal
    {
        @Override
        public String toString() {

            String str = new Default().private_;

            return super.toString();
        }
    }
}
