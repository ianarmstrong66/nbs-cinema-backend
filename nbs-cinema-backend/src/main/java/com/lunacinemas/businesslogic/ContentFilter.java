package com.lunacinemas.businesslogic;

abstract class ContentFilter extends StringManipulator {

    private String[] prohibitedWords = {"shit", "fuck" , "santander", "rbs", "halifax", "lloyds", "natwest", "TSB", "monzo"};

    protected String filter(String contentToBeFiltered, ResponseObject responseObject){
        String filteredString = contentToBeFiltered;
        for (String word : prohibitedWords){
            if (filteredString.toLowerCase().contains(word)){
                filteredString = filteredString.replaceAll(getRegex(word),getStars(word.length()));
                responseObject.addToBody("Words were censored. ");
            }
        }
        return filteredString;
    }

    private String getStars(int numberOfStars){
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < numberOfStars ; i++){
            result.append("*");
        }
        return result.toString();
    }

}
