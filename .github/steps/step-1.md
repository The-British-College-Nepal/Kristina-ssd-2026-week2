# 🔤 SSD Week 2 Lab: Interfaces in Java & Git Branching
**Software Systems Development (CRN 12391) · Level 5**  
**The British College (Leeds Beckett University)**

```
Progress: [██████░░░░░░░░░░░░] Step 1 of 3 (In Progress)
```

---

## 🎯 Welcome to Week 2: Interfaces & Git Branching!

Welcome! In this hands-on lab, you will master two fundamental software engineering practices:
1. **Java Interfaces & Polymorphism:** Creating clean, decoupled code by programming to an interface contract.
2. **Professional Git Branching:** Learning why engineers never commit directly to `main`, and practicing feature branches (`git checkout -b`, `git merge`).

Just like GitHub Skills:
1. You work on your assigned feature branch.
2. Merge your completed feature into `main` and push.
3. GitHub Actions automatically tests your code.
4. When tests pass, **this README automatically updates to reveal Step 2!**

---

## 🌿 Mandatory Rule: Work in a Feature Branch!

> [!IMPORTANT]
> **DO NOT commit directly to `main`!**  
> In modern software teams, direct commits to `main` are restricted. All new features are developed on a separate branch and integrated cleanly once verified.

### 🚀 Git Branching Quick Guide (Follow These Steps):

Open your terminal inside this repository and run:

```bash
# 1. Ensure you are on main and up to date
git checkout main
git pull origin main

# 2. Create and switch to your new feature branch for Step 1
git checkout -b feature/step1-counter

# Verify which branch you are on (it should show * feature/step1-counter)
git branch
```

---

## 📝 Step 1 Task: The `Counter` Interface Contract

Examine [`src/main/java/counter/Counter.java`](src/main/java/counter/Counter.java) in your IDE.

An interface is a **pure contract**. It specifies *what* operations must be provided, without providing the implementation code.

### Your Tasks:
1. Open [`Counter.java`](src/main/java/counter/Counter.java).
2. Ensure `Counter` is declared as an interface:
   ```java
   public interface Counter {
       int countWords(String sentence);
       int countLetters(String sentence);
       int getLength(String sentence);
   }
   ```
3. Notice that all three methods are implicitly `public` and `abstract`.
4. Read the Javadoc comments above each method to understand the required behavior.

---

## 🧪 Verify Step 1 Locally

Run the unit tests for Step 1 in your IDE or terminal:

```bash
mvn test -Dtest=Step1CounterTest
```

Expected output:
```
[INFO] Running counter.Step1CounterTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 🚀 Commit, Merge & Advance to Step 2

Once your Step 1 tests pass, practice the Git branching workflow to submit your work:

```bash
# 1. Stage and commit your changes on your feature branch
git add .
git commit -m "feat(counter): verify Step 1 Counter interface contract"

# 2. Push your feature branch to GitHub
git push -u origin feature/step1-counter

# 3. Switch back to main and merge your feature branch
git checkout main
git merge feature/step1-counter

# 4. Push main to trigger the autograder!
git push origin main
```

> 💡 **Next:** Once pushed to `main`, wait a few seconds, then run `git pull origin main` in your terminal or refresh this page on GitHub to unlock **Step 2: Implement WordProcessor.java**!
