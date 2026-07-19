# 🐟 GoldFish - Context ChatBot

A Java-based AI chatbot powered by **Google Gemini 2.5 Flash API** that remembers the conversation history and generates context-aware responses.

Unlike a basic chatbot that only responds to the latest message, this project sends the previous conversation along with every new prompt, allowing the AI to maintain context throughout the chat.

---

# Features

- 🤖 AI-powered chatbot using Google Gemini API
- 🧠 Conversation history using `ArrayList`
- 💬 Context-aware responses
- 🌐 HTTP API integration using Java HttpClient
- 📦 JSON parsing using Jackson
- ⚡ Built with Maven
- 🔑 Prompts the user for their API key at runtime

---

# Technologies Used

- Java 21+
- Maven
- Google Gemini 2.5 Flash API
- Jackson Databind
- Java HttpClient

---

# Project Structure

```
Context-ChatBot
│
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── manasvi
│   │               └── contextchatbot
│   │                   └── Context.java
│   │
│   └── test
│
├── pom.xml
└── README.md
```

---

# How It Works

1. The application asks the user to enter their Gemini API key.
2. The user enters a message.
3. Every user message is stored in an `ArrayList`.
4. The complete conversation history is converted into a single prompt.
5. The prompt is sent to the Gemini API.
6. Gemini generates a context-aware response.
7. The AI response is also stored in the conversation history.
8. The process repeats until the user types:

```
bye
```

---

# Getting Started

## Clone the Repository

```bash
git clone https://github.com/manasvireddyyy/Context-ChatBot.git
```

Move into the project directory.

```bash
cd Context-ChatBot
```

---

## Install Dependencies

Compile the project using Maven.

```bash
mvn clean compile
```

---

## Run the Application

```bash
mvn exec:java -Dexec.mainClass="com.manasvi.contextchatbot.Context"
```

---

# Gemini API Key

⚠️ **Important**

This project **does not include an API key**.

For security reasons, every user must provide **their own Google Gemini API Key** when running the application.

You can generate your own API key from:

https://aistudio.google.com/app/apikey

When the application starts, it will ask:

```
Enter your Gemini API Key:
```

Paste your key and begin chatting.

---

# Example Conversation

```
Enter your Gemini API Key:
AIzaSy************************

You: Hi

GoldFish:
Hello! How can I help you today?

You: My name is Manasvi.

GoldFish:
Nice to meet you, Manasvi!

You: What is my name?

GoldFish:
Your name is Manasvi.
```

---

# Screenshots

## JSON Response from Gemini API

<img width="686" height="736" alt="Screenshot 2026-07-19 at 6 07 22 PM" src="https://github.com/user-attachments/assets/be346b4d-2f16-4737-b19b-2ab411b3ccee" />


---

## ChatBot Output

<img width="753" height="512" alt="Screenshot 2026-07-19 at 6 20 47 PM" src="https://github.com/user-attachments/assets/84f4ba42-1a08-4eea-aa8a-8015f290aab4" />


---

# Future Improvements

- Save conversation history to files
- Long-term memory
- Streaming AI responses
- Voice input
- Voice output
- Tool calling
- Web Search
- PDF Chat
- GUI/Desktop Application

---

# Learning Objectives

This project helped me learn:

- Java Collections (`ArrayList`)
- REST API Integration
- JSON Parsing
- HTTP Requests
- Context Management
- Maven
- Object-Oriented Programming
- Error Handling

---

# Author

**Manasvi Reddy**

GitHub:
https://github.com/manasvireddyyy

---

⭐ If you found this project interesting, consider giving it a star!
