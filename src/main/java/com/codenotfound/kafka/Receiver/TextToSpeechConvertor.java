//package com.codenotfound.kafka.Receiver;
//
//
//import com.sun.speech.freetts.Voice;
//import com.sun.speech.freetts.VoiceManager;
//
//public class TextToSpeechConvertor {
//    private static final String VOICE_NAME_KEVIN = "kevin16";
////    private final Voice voice;
////
////    public TextToSpeechConvertor() {
////        VoiceManager vm = VoiceManager.getInstance();
////        voice = vm.getVoice(VOICE_NAME_KEVIN);
////        voice.allocate();
////    }
////
////    public void speak(String inputText) {
////
////        if(inputText != null && !inputText.isEmpty()) {
////
////            voice.speak(inputText);
////        }
////    }
//
//    VoiceManager freettsVM;
//    Voice freettsVoice;
//    private Voice voice;
//
//    public TextToSpeechConvertor(){
//        VoiceManager vm = VoiceManager.getInstance();
//        voice = vm.getVoice(VOICE_NAME_KEVIN);
//        voice.allocate();
//
//    }
//    public void speak(String msg) {
//        voice.speak(msg);
//        voice.deallocate();
//    }
//}
////public class Main {
////    public static void main(String[] args) {
////        String speekstring = txtmassage.getText();
////        s t = new s("kevin16");
////        t.speak(speekstring);}
////}
//
