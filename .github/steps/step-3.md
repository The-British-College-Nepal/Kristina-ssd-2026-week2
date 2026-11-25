# 🔤 SSD Week 2 Lab: Interfaces in Java & Git Branching
**Software Systems Development (CRN 12391) · Level 5**  
**The British College (Leeds Beckett University)**

```
Progress: [██████████████████] Step 3 of 3 (In Progress)
```

---

## 🎉 Step 2 Completed! Welcome to Step 3

You have successfully implemented the `Counter` interface in `WordProcessor`. Now, we will add **state encapsulation, null safety, and examine polymorphism**.

---

## 🌿 Step 3: Create Your Final Feature Branch

```bash
# 1. Pull the latest main
git checkout main
git pull origin main

# 2. Create the Step 3 branch
git checkout -b feature/step3-fallback-text
```

---

## 📝 Step 3 Task: Encapsulation & Fallback State

Open [`src/main/java/counter/WordProcessor.java`](src/main/java/counter/WordProcessor.java).

In practical applications, methods often need sensible fallback defaults when callers pass `null`.

### Your Tasks:

1. **Add Encapsulated Attribute `text`:**
   * Declare a private field:
     ```java
     private String text = "";
     ```
   * Enforce encapsulation: it **must** be `private`!

2. **Implement Getters and Setters:**
   * `public String getText()` $\rightarrow$ returns `this.text`.
   * `public void setText(String text)` $\rightarrow$ sets `this.text = text`.

3. **Implement Null Fallback Behavior:**
   * At the top of `countWords`, `countLetters`, and `getLength`, check if `sentence == null`.
   * If `sentence == null`, reassign it to the fallback:
     ```java
     if (sentence == null) {
         sentence = this.text;
     }
     ```
   * If a non-null string is passed, the method evaluates that string normally.

4. **Run `Driver.java` to test polymorphism:**
   Open [`src/main/java/counter/Driver.java`](src/main/java/counter/Driver.java) and run it!
   * Notice line 18:
     ```java
     Counter wp = new WordProcessor();
     ```
     This is **Polymorphism**: the variable is typed as `Counter`, but instantiated as `WordProcessor`.
   * Notice line 29:
     ```java
     WordProcessor wp2 = new WordProcessor();
     wp2.setText("The British College Kathmandu Nepal");
     ```
     Why can we not call `wp.setText()` on line 18? Because `setText()` is specific to `WordProcessor` and is not part of the `Counter` interface contract!

---

## 🧪 Verify Step 3 Locally

Run all unit tests across the entire suite:

```bash
mvn test
```

Expected output:
```
[INFO] Running counter.Step1CounterTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running counter.Step2WordProcessorTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running counter.Step3FallbackTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 🚀 Commit, Merge & Finish the Lab!

```bash
# 1. Commit your changes on feature/step3-fallback-text
git add src/main/java/counter/WordProcessor.java
git commit -m "feat(wordprocessor): add fallback state encapsulation and null handling"

# 2. Push your feature branch
git push -u origin feature/step3-fallback-text

# 3. Merge into main
git checkout main
git merge feature/step3-fallback-text

# 4. Push main to claim your completion badge!
git push origin main
```

> 💡 **Next:** Run `git pull origin main` to see your final **Completion Badge**!
