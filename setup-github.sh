#!/bin/bash

# Script de configuration GitHub pour ToDoList Collaborative
# Usage: ./setup-github.sh <votre-username-github>

if [ $# -eq 0 ]; then
    echo "Usage: $0 <votre-username-github>"
    echo "Exemple: $0 rickdev"
    exit 1
fi

GITHUB_USERNAME=$1
REPO_NAME="todolist-collaborative"

echo "🚀 Configuration GitHub pour ToDoList Collaborative"
echo "=================================================="
echo ""

echo "📋 Étapes à suivre :"
echo ""

echo "1️⃣  Créer le repository sur GitHub :"
echo "   - Allez sur https://github.com/new"
echo "   - Nom: $REPO_NAME"
echo "   - Description: Application web collaborative de gestion de tâches avec Spring Boot, Angular et MySQL"
echo "   - Visibilité: Public"
echo "   - Ne pas initialiser avec README"
echo ""

echo "2️⃣  Connecter le repository local :"
echo "   git remote add origin https://github.com/$GITHUB_USERNAME/$REPO_NAME.git"
echo "   git push -u origin main"
echo "   git push -u origin develop"
echo ""

echo "3️⃣  Configurer les branches protégées :"
echo "   - Allez dans Settings > Branches"
echo "   - Ajoutez une règle pour 'main' avec protection"
echo "   - Ajoutez une règle pour 'develop' avec protection"
echo ""

echo "4️⃣  Inviter les collaborateurs :"
echo "   - Allez dans Settings > Manage access"
echo "   - Cliquez sur 'Invite a collaborator'"
echo "   - Ajoutez les emails/usernames de votre équipe"
echo ""

echo "5️⃣  Créer le Project Board :"
echo "   - Allez dans l'onglet Projects"
echo "   - Créez un nouveau projet 'Basic kanban'"
echo "   - Nom: 'ToDoList Collaborative - Sprint Planning'"
echo ""

echo "6️⃣  Configurer les labels :"
echo "   - Allez dans Issues > Labels"
echo "   - Ajoutez les labels recommandés dans PROJECT_SETUP.md"
echo ""

echo "7️⃣  Activer les Discussions :"
echo "   - Allez dans Settings > General"
echo "   - Activez 'Discussions'"
echo ""

echo "📁 Structure du projet créée :"
echo "   ✅ Backend Spring Boot avec pom.xml"
echo "   ✅ Frontend Angular avec package.json"
echo "   ✅ Configuration Docker avec docker-compose.yml"
echo "   ✅ Base de données MySQL avec schéma"
echo "   ✅ Documentation complète"
echo "   ✅ CI/CD Pipeline GitHub Actions"
echo "   ✅ Templates d'issues et PR"
echo "   ✅ Guide de contribution"
echo ""

echo "🔗 Liens utiles après création :"
echo "   Repository: https://github.com/$GITHUB_USERNAME/$REPO_NAME"
echo "   Issues: https://github.com/$GITHUB_USERNAME/$REPO_NAME/issues"
echo "   Projects: https://github.com/$GITHUB_USERNAME/$REPO_NAME/projects"
echo "   Actions: https://github.com/$GITHUB_USERNAME/$REPO_NAME/actions"
echo ""

echo "📖 Documentation disponible :"
echo "   - README.md : Vue d'ensemble du projet"
echo "   - CONTRIBUTING.md : Guide de contribution"
echo "   - PROJECT_SETUP.md : Configuration GitHub détaillée"
echo "   - docs/ : Documentation technique complète"
echo ""

echo "🎉 Votre projet est prêt pour la collaboration !"
echo "   Partagez le lien du repository avec votre équipe"
echo "   Suivez les étapes dans PROJECT_SETUP.md pour la configuration complète"
